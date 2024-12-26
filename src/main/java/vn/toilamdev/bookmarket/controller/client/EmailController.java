package vn.toilamdev.bookmarket.controller.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.toilamdev.bookmarket.service.EmailService;

@RestController
@RequestMapping("/api/v1")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/email")
    public ResponseEntity<Object> sendSimpleEmail() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "ok");

        this.emailService.sendEmailFromTemplateSync("n20dcvt009@student.ptithcm.edu.vn",
                "Test Template", "email/template-send-email", false, true);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
