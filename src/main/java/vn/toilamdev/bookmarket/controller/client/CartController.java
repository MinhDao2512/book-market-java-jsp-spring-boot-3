package vn.toilamdev.bookmarket.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart-detail")
public class CartController {
    @GetMapping
    public String getCartDetailPage(Model model) {
        return "client/homepage/homepage-cart-detail";
    }
}
