package vn.toilamdev.bookmarket.controller.client;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import vn.toilamdev.bookmarket.constant.SystemConstant;
import vn.toilamdev.bookmarket.domain.Book;
import vn.toilamdev.bookmarket.domain.Order;
import vn.toilamdev.bookmarket.domain.User;
import vn.toilamdev.bookmarket.service.BookService;
import vn.toilamdev.bookmarket.service.OrderService;
import vn.toilamdev.bookmarket.service.UserService;
import vn.toilamdev.bookmarket.utils.PaginationUtils;

@Controller
@RequestMapping("/")
public class HomeController {
    private final BookService bookService;
    private final OrderService orderService;
    private final UserService userService;

    public HomeController(BookService bookService, OrderService orderService, UserService userService) {
        this.bookService = bookService;
        this.orderService = orderService;
        this.userService = userService;
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
    public String getThanksPage(Model model, @RequestParam(value = "vnp_TxnRef", required = false) String paymentRef,
            @RequestParam(value = "vnp_ResponseCode", required = false) String responseCode) {

        if (paymentRef != null && responseCode != null) {
            // Update Order Status
            Order currentOrder = this.orderService.getOrderByPaymentRef(paymentRef);
            if (responseCode.equals("00")) {
                currentOrder.setPaymentStatus(SystemConstant.PAYMENT_STATUS_SUCCEED);
            } else {
                currentOrder.setPaymentStatus(SystemConstant.PAYMENT_STATUS_FAILED);
                model.addAttribute("failed", "true");
            }
            model.addAttribute(SystemConstant.PAYMENT_METHOD_BANKING, "true");
            this.orderService.createOrUpdateOrder(currentOrder);
        } else {
            model.addAttribute(SystemConstant.PAYMENT_METHOD_COD, "true");
        }

        return "client/homepage/homepage-response-place-order";
    }

    @GetMapping("orders")
    public String getOrderPage(Model model, HttpServletRequest request,
            @RequestParam(value = "page", required = false) String nextPage) {
        HttpSession session = request.getSession();

        long userId = (long) session.getAttribute("id");
        User user = this.userService.getUserById(userId);

        int page = 1;
        int orderCount = user.getOrders().size();
        int totalPages = 1;
        int limit = 5;
        int maxVisible = SystemConstant.MAX_VISIBLE_PAGES;

        if (nextPage != null) {
            page = Integer.parseInt(nextPage);
        }

        Pageable pageable = PageRequest.of(page - 1, limit);
        List<Order> orders = this.orderService.getListOrdersByUser(user, pageable);

        if (orderCount % limit != 0) {
            totalPages = orderCount / limit + 1;
        } else {
            totalPages = orderCount / limit;
        }

        List<Integer> pageNumbers = PaginationUtils.getPageNumbers(page, totalPages, maxVisible);

        model.addAttribute("orders", orders);
        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "client/homepage/homepage-order";
    }
}
