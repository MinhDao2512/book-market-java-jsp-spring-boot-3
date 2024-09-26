package vn.toilamdev.bookmarket.controller.admin;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.toilamdev.bookmarket.constant.SystemConstant;
import vn.toilamdev.bookmarket.domain.Role;
import vn.toilamdev.bookmarket.domain.User;
import vn.toilamdev.bookmarket.dto.UserDTO;
import vn.toilamdev.bookmarket.mapper.UserMapper;
import vn.toilamdev.bookmarket.service.RoleService;
import vn.toilamdev.bookmarket.service.UploadFileService;
import vn.toilamdev.bookmarket.service.UserService;

@Controller
@RequestMapping("/admin/user")
public class UserController {
    private final PasswordEncoder passwordEncoder;
    private final UploadFileService uploadFileService;
    private final RoleService roleService;
    private final UserService userService;

    public UserController(PasswordEncoder passwordEncoder, UploadFileService uploadFileService,
            RoleService roleService, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.uploadFileService = uploadFileService;
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "admin/user/user-create";
    }

    @PostMapping("/create")
    public String postCreateAUser(@ModelAttribute("userDTO") UserDTO userDTO,
            @RequestParam("avatarFile") MultipartFile file) {
        // After Validation
        Role role = this.roleService.getRoleByName(userDTO.getRole().getName());
        String fileName = this.uploadFileService.handleSaveFile(file, "avatar");

        User user = UserMapper.mappingUserDTO(userDTO);
        user.setPassword(this.passwordEncoder.encode(userDTO.getPassword()));
        user.setRole(role);

        if (fileName != "") {
            user.setAvatar(fileName);
        } else {
            user.setAvatar(SystemConstant.FILE_NAME_DEFAULT);
        }

        user.setCreatedAt(LocalDateTime.now());

        // Save User
        this.userService.saveOrUpdateUser(user);
        return "redirect:/admin/user";
    }
}
