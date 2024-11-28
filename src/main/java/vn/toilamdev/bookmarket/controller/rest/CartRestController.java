package vn.toilamdev.bookmarket.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
public class CartRestController {
    @PostMapping
    public ResponseEntity<Object> addBookTCart() {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
