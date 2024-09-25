package vn.toilamdev.bookmarket.controller.admin;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.toilamdev.bookmarket.domain.User;
import vn.toilamdev.bookmarket.dto.UserDTO;
import vn.toilamdev.bookmarket.mapper.UserMapper;

@Controller
@RequestMapping("/admin/user")
public class UserController {
    private final PasswordEncoder passwordEncoder;

    public UserController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "admin/user/user-create";
    }

    @PostMapping("/create")
    public String postCreateAUser(@ModelAttribute("userDTO") UserDTO userDTO,
            @RequestParam("avatarFile") MultipartFile file) {
        User user = UserMapper.mappingUserDTO(userDTO);
        user.setPassword(this.passwordEncoder.encode(userDTO.getPassword()));
        System.out.println(user.getPassword());
        return "redirect:/admin/user";
    }
}
