package vn.toilamdev.bookmarket.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import vn.toilamdev.bookmarket.domain.User;
import vn.toilamdev.bookmarket.service.UserService;

@Controller
@RequestMapping("/cart-detail")
public class CartController {

    private final UserService userService;

    public CartController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getCartDetailPage(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        long userId = (long) session.getAttribute("id");
        User currentUser = this.userService.getUserById(userId);

        model.addAttribute("cartItems", currentUser.getCart().getCartItems());
        return "client/homepage/homepage-cart-detail";
    }
}
