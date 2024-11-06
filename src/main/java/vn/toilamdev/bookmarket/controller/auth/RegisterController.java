package vn.toilamdev.bookmarket.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @GetMapping
    public String getRegisterPage(Model model) {
        return "auth/register";
    }
}
