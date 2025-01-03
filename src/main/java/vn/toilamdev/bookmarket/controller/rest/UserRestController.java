package vn.toilamdev.bookmarket.controller.rest;

import java.util.Map;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
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
    public ResponseEntity<?> createUser(@Valid @ModelAttribute UserDTO userDTO, BindingResult bindingResult,
            @RequestParam("avatarFile") MultipartFile multipartFile) {
        // Validate Data
        if (bindingResult.hasFieldErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }
        // After Validation
        User newUser = this.userService.handleCreateUser(userDTO, multipartFile);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@Valid @ModelAttribute User user, BindingResult bindingResult,
            @RequestParam("avatarFile") MultipartFile multipartFile, @PathVariable("id") long id) {

        if (bindingResult.hasFieldErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        User currentUser = this.userService.getUserById(id);
        if (currentUser != null) {
            currentUser = this.userService.handleUpdateUser(user, currentUser, multipartFile);
            return ResponseEntity.status(HttpStatus.OK).body(currentUser);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") long id) {
        User currentUser = this.userService.getUserById(id);
        this.userService.handleDeleteUser(currentUser);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
