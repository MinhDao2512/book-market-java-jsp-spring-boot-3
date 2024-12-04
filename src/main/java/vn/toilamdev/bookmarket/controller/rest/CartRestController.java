package vn.toilamdev.bookmarket.controller.rest;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import vn.toilamdev.bookmarket.domain.Book;
import vn.toilamdev.bookmarket.domain.Cart;
import vn.toilamdev.bookmarket.domain.User;
import vn.toilamdev.bookmarket.service.BookService;
import vn.toilamdev.bookmarket.service.CartService;
import vn.toilamdev.bookmarket.service.UserService;

@RestController
@RequestMapping("/api/cart")
public class CartRestController {
    private final CartService cartService;
    private final UserService userService;
    private final BookService bookService;

    public CartRestController(CartService cartService, UserService userService, BookService bookService) {
        this.cartService = cartService;
        this.userService = userService;
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Object> addBookTCart(@RequestParam("bookId") long bookId,
            @RequestParam("bookCount") int bookCount, HttpServletRequest httpServletRequest) {
        // Get Book
        Book book = this.bookService.getBookById(bookId);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("message", "The product is not exists."));
        } else if (book.getQuantity() - bookCount <= 0) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Collections.singletonMap("message", "The product is out of stock."));
        } else {
            // Get Session
            HttpSession session = httpServletRequest.getSession(false);
            // Get Current User
            long userId = (long) session.getAttribute("id");
            User currentUser = this.userService.getUserById(userId);
            // Add Book To Cart
            Cart newCart = this.cartService.addToCart(currentUser, book, bookCount);

            session.setAttribute("cartCount", newCart.getCartItems().size());
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(Collections.singletonMap("newCartCount", newCart.getCartItems().size()));
        }

    }
}
