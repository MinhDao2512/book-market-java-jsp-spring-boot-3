package vn.toilamdev.bookmarket.controller.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import vn.toilamdev.bookmarket.domain.User;
import vn.toilamdev.bookmarket.domain.User_;
import vn.toilamdev.bookmarket.dto.UserDTO;
import vn.toilamdev.bookmarket.service.UserService;

@RestController
@RequestMapping("/api/register")
public class RegisterRestController {

    private final UserService userService;

    public RegisterRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> registerAccount(@Valid @ModelAttribute UserDTO userDTO, BindingResult bindingResult,
            @RequestParam("fullName") String fullName) {
        Map<String, String> errors = new HashMap<>();
        boolean existsUser = false;

        if (bindingResult.hasFieldErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                if (fieldError.getField().equals(User_.EMAIL) || fieldError.getField().equals(User_.PASSWORD)
                        || fieldError.getField().equals(User_.PHONE_NUMBER)) {
                    errors.put(fieldError.getField(), fieldError.getDefaultMessage());
                    existsUser = true;
                }
            }
        }

        if (existsUser) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        } else {
            User newUser = this.userService.handleCreateUser(userDTO, fullName);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        }
    }
}
