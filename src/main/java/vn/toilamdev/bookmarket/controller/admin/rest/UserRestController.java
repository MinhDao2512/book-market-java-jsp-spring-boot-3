package vn.toilamdev.bookmarket.controller.admin.rest;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import vn.toilamdev.bookmarket.constant.SystemConstant;
import vn.toilamdev.bookmarket.domain.Role;
import vn.toilamdev.bookmarket.domain.User;
import vn.toilamdev.bookmarket.dto.UserDTO;
import vn.toilamdev.bookmarket.mapper.UserMapper;
import vn.toilamdev.bookmarket.service.RoleService;
import vn.toilamdev.bookmarket.service.UploadFileService;
import vn.toilamdev.bookmarket.service.UserService;

@RestController
@RequestMapping("/api/admin")
public class UserRestController {

    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final UploadFileService uploadFileService;
    private final UserService userService;

    public UserRestController(RoleService roleService, PasswordEncoder passwordEncoder,
            UploadFileService uploadFileService, UserService userService) {
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.uploadFileService = uploadFileService;
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<Void> createUser(@ModelAttribute UserDTO userDTO,
            @RequestParam("avatarFile") MultipartFile multipartFile) {
        // After Validation
        Role role = this.roleService.getRoleByName(userDTO.getRoleName());
        User newUser = UserMapper.mappingUserDTO(userDTO);

        newUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        newUser.setRole(role);

        if (multipartFile.getOriginalFilename() == "" ||
                multipartFile.getOriginalFilename() == null) {
            newUser.setAvatar(SystemConstant.AVATAR_NAME_DEFAULT);
        } else {
            newUser.setAvatar(this.uploadFileService.handleSaveFile(multipartFile,
                    SystemConstant.DIRECTORY_AVATAR));
        }
        newUser.setCreatedAt(new Date(System.currentTimeMillis()));

        this.userService.saveOrUpdateUser(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}
