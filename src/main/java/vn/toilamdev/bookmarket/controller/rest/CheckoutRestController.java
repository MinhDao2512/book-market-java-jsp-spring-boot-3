package vn.toilamdev.bookmarket.controller.rest;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import vn.toilamdev.bookmarket.domain.Order;
import vn.toilamdev.bookmarket.domain.User;
import vn.toilamdev.bookmarket.service.OrderService;
import vn.toilamdev.bookmarket.service.UserService;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutRestController {
    private final OrderService orderService;
    private final UserService userService;

    public CheckoutRestController(OrderService orderService,
            UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> proceedToPayment(Model model, @RequestBody Order order, HttpServletRequest request) {
        HttpSession session = request.getSession();
        long userId = (long) session.getAttribute("id");
        User currentUser = this.userService.getUserById(userId);

        Order newOrder = this.orderService.createNewOrder(order, currentUser);

        if (newOrder != null) {
            session.setAttribute("totalCartPrice", 0);
            session.setAttribute("cartCount", 0);
            return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("message", "success"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("message", "error"));
        }
    }
}
