package vn.toilamdev.bookmarket.controller.admin.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import vn.toilamdev.bookmarket.domain.User;
import vn.toilamdev.bookmarket.dto.UserDTO;
import vn.toilamdev.bookmarket.service.UserService;

@RestController
@RequestMapping("/api/admin")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<Void> createUser(@ModelAttribute UserDTO userDTO,
            @RequestParam("avatarFile") MultipartFile multipartFile) {
        // After Validation
        this.userService.handleCreateUser(userDTO, multipartFile);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Void> updateUser(@ModelAttribute User user,
            @RequestParam("avatarFile") MultipartFile multipartFile, @PathVariable long id) {
        User currentUser = this.userService.getUserById(id);
        this.userService.handleUpdateUser(user, currentUser, multipartFile);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        User currentUser = this.userService.getUserById(id);
        this.userService.handleDeleteUser(currentUser);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
