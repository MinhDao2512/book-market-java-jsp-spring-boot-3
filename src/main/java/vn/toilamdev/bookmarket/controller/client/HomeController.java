package vn.toilamdev.bookmarket.controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.toilamdev.bookmarket.constant.SystemConstant;
import vn.toilamdev.bookmarket.domain.Book;
import vn.toilamdev.bookmarket.domain.Order;
import vn.toilamdev.bookmarket.service.BookService;
import vn.toilamdev.bookmarket.service.OrderService;

@Controller
@RequestMapping("/")
public class HomeController {
    private final BookService bookService;
    private final OrderService orderService;

    public HomeController(BookService bookService, OrderService orderService) {
        this.bookService = bookService;
        this.orderService = orderService;
    }

    @GetMapping
    public String getHomePage(Model model) {
        List<Book> books = this.bookService.getAllBooks();

        model.addAttribute("books", books);

        return "client/homepage/homepage-home";
    }

    @GetMapping("access-deny")
    public String getDenyPage(Model model) {
        return "errors/403";
    }

    @GetMapping("response-place-order")
    public String getThanksPage(Model model, @RequestParam("vnp_TxnRef") String paymentRef,
            @RequestParam("vnp_ResponseCode") String responseCode) {

        // Update Order Status
        Order currentOrder = this.orderService.getOrderByPaymentRef(paymentRef);
        if (responseCode.equals("00")) {
            currentOrder.setPaymentStatus(SystemConstant.PAYMENT_STATUS_SUCCEED);
        } else {
            currentOrder.setPaymentStatus(SystemConstant.PAYMENT_STATUS_FAILED);
            model.addAttribute("failed", "true");
        }

        this.orderService.createOrUpdateOrder(currentOrder);

        return "client/homepage/homepage-response-place-order";
    }
}
