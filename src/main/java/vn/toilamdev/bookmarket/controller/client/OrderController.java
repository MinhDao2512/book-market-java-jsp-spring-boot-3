package vn.toilamdev.bookmarket.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.toilamdev.bookmarket.domain.Order;
import vn.toilamdev.bookmarket.service.OrderService;

@Controller(value = "client")
@RequestMapping("/orders/detail")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public String getOrderDetailPage(Model model, @PathVariable long id) {
        Order currentOrder = this.orderService.getOrderById(id);

        model.addAttribute("orderItems", currentOrder.getOrderItems());
        model.addAttribute("orderCode", currentOrder.getPaymentRef());
        return "client/homepage/homepage-order-detail";
    }
}
