package vn.toilamdev.bookmarket.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.toilamdev.bookmarket.domain.Order;
import vn.toilamdev.bookmarket.service.OrderService;

@Controller
@RequestMapping("/admin/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/detail/{id}")
    public String getOrderDetailPage(Model model, @PathVariable long id) {
        Order currentOrder = this.orderService.getOrderById(id);
        model.addAttribute("currentOrder", currentOrder);
        return "admin/order/order-detail";
    }
}
