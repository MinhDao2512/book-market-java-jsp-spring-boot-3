package vn.toilamdev.bookmarket.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forgot")
public class ForgotPasswordController {

    @GetMapping
    public String getForgotPasswordPage(Model model) {
        return "client/auth/forgot";
    }
}
