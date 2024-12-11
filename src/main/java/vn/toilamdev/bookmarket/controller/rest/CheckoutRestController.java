package vn.toilamdev.bookmarket.controller.rest;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import vn.toilamdev.bookmarket.constant.SystemConstant;
import vn.toilamdev.bookmarket.domain.Order;
import vn.toilamdev.bookmarket.domain.User;
import vn.toilamdev.bookmarket.dto.OrderDTO;
import vn.toilamdev.bookmarket.service.OrderService;
import vn.toilamdev.bookmarket.service.UserService;
import vn.toilamdev.bookmarket.service.VNPayService;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutRestController {
    private final OrderService orderService;
    private final UserService userService;
    private final VNPayService vnPayService;

    @PostMapping
    public ResponseEntity<Object> proceedToPayment(Model model, @RequestBody OrderDTO orderDTO,
            HttpServletRequest request) throws UnsupportedEncodingException {
        HttpSession session = request.getSession();
        long userId = (long) session.getAttribute("id");
        User currentUser = this.userService.getUserById(userId);
        String uuid = UUID.randomUUID().toString().replace("-", "");

        Order newOrder = this.orderService.createNewOrder(orderDTO, currentUser, uuid);

        Map<String, String> responseData = new HashMap<>();

        if (newOrder != null) {
            if (orderDTO.getBookId() == 0) {
                session.setAttribute("totalCartPrice", 0);
                session.setAttribute("cartCount", 0);
            }

            if (orderDTO.getPaymentMethod().equals(SystemConstant.PAYMENT_METHOD_BANKING)) {
                String ip = this.vnPayService.getIpAddress(request);
                String vnpUrl = this.vnPayService.generateVNPayURL(newOrder.getTotalPrice(), uuid, ip);
                responseData.put("vnpUrl", vnpUrl);
            }
            responseData.put("paymentMethod", orderDTO.getPaymentMethod());

            return ResponseEntity.status(HttpStatus.OK).body(responseData);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("message", "error"));
        }
    }

    public CheckoutRestController(OrderService orderService, UserService userService, VNPayService vnPayService) {
        this.orderService = orderService;
        this.userService = userService;
        this.vnPayService = vnPayService;
    }
}
