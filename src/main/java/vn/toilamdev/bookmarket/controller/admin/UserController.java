package vn.toilamdev.bookmarket.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/user")
public class UserController {

    @GetMapping("/create")
    public String getCreateUserPage() {
        return "admin/user/user-create";
    }

}
