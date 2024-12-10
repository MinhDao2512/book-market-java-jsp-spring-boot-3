package vn.toilamdev.bookmarket.controller.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import vn.toilamdev.bookmarket.domain.Book;
import vn.toilamdev.bookmarket.domain.CartItem;
import vn.toilamdev.bookmarket.domain.User;
import vn.toilamdev.bookmarket.service.BookService;
import vn.toilamdev.bookmarket.service.UserService;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {
    private final UserService userService;
    private final BookService bookService;

    public CheckoutController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @GetMapping
    public String getCheckoutPage(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        long userId = (long) session.getAttribute("id");

        User user = this.userService.getUserById(userId);

        model.addAttribute("currentUser", user);
        model.addAttribute("cartItems", user.getCart().getCartItems());
        return "client/homepage/homepage-checkout";
    }

    @GetMapping("/buy-now")
    public String getCheckoutPageForBuyNow(Model model, HttpServletRequest request, @RequestParam("bookId") long bookId,
            @RequestParam("quantity") int quantity) {
        HttpSession session = request.getSession();
        long userId = (long) session.getAttribute("id");

        User user = this.userService.getUserById(userId);
        Book book = this.bookService.getBookById(bookId);

        List<CartItem> cartItems = new ArrayList<>();
        CartItem cartItem = new CartItem();
        cartItem.setBook(book);
        cartItem.setTotalPrice(book.getPrice() * quantity);
        cartItem.setQuantity(quantity);
        cartItems.add(cartItem);

        model.addAttribute("currentUser", user);
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("bookId", bookId);
        model.addAttribute("totalPrice", cartItem.getTotalPrice());

        return "client/homepage/homepage-checkout";
    }
}
