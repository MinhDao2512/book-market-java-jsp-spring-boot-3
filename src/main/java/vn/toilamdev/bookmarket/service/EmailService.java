package vn.toilamdev.bookmarket.service;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import vn.toilamdev.bookmarket.constant.SystemConstant;

@Service
public class EmailService {
    private final JavaMailSender javaMailSender;
    private final MailSender mailSender;
    private final ApplicationContext applicationContext;
    private final HttpServletRequest request;

    public EmailService(JavaMailSender javaMailSender, MailSender mailSender, ApplicationContext applicationContext,
            HttpServletRequest request) {
        this.javaMailSender = javaMailSender;
        this.mailSender = mailSender;
        this.applicationContext = applicationContext;
        this.request = request;
    }

    // Send Email with Simple Text
    public void sendSimpleEmail(String to, String subject, String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);

        mailSender.send(simpleMailMessage);
    }

    private void sendEmailSync(String to, String subject, String content, boolean isMultipart, boolean isHtml) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, isMultipart,
                    StandardCharsets.UTF_8.name());

            messageHelper.setFrom(SystemConstant.FROM_NAME);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(content, isHtml);

            this.javaMailSender.send(mimeMessage);
        } catch (MailException | MessagingException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("null")
    public void sendEmailFromTemplateSync(String to, String subject, String templateName, boolean isMultipart,
            boolean isHtml) {
        try {
            InternalResourceViewResolver viewResolver = applicationContext.getBean(InternalResourceViewResolver.class);

            View view = viewResolver.resolveViewName(templateName, Locale.getDefault());

            MockHttpServletResponse mockResponse = new MockHttpServletResponse();

            Map<String, Object> model = new HashMap<>();
            model.put("userName", "Dao");

            view.render(model, request, mockResponse);
            String emailContent = mockResponse.getContentAsString();

            sendEmailSync(to, subject, emailContent, isMultipart, isHtml);
        } catch (BeansException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
