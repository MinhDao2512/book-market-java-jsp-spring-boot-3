package vn.toilamdev.bookmarket.controller.admin.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import vn.toilamdev.bookmarket.dto.UserDTO;

@RestController
@RequestMapping("/api/admin")
public class UserRestController {
    @PostMapping("/users")
    public ResponseEntity<Void> createUser(@ModelAttribute UserDTO userDTO,
            @RequestParam("avatarFile") MultipartFile multipartFile) {

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
}
