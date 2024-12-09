package vn.toilamdev.bookmarket.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import vn.toilamdev.bookmarket.domain.CartItem;
import vn.toilamdev.bookmarket.domain.Order;
import vn.toilamdev.bookmarket.domain.OrderItem;
import vn.toilamdev.bookmarket.domain.User;
import vn.toilamdev.bookmarket.repository.CartItemRepository;
import vn.toilamdev.bookmarket.repository.CartRepository;
import vn.toilamdev.bookmarket.repository.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    public OrderService(OrderRepository orderRepository, CartRepository cartRepository,
            CartItemRepository cartItemRepository) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public Order createOrUpdateOrder(Order order) {
        return this.orderRepository.save(order);
    }

    public Order createNewOrder(Order order, User user) {
        order.setCreatedAt(new Date(System.currentTimeMillis()));

        order.setShippingMethod("GHTK");
        order.setShippingStatus("In Transit");

        if (order.getPaymentMethod().equals("VNPAY")) {
            order.setPaymentStatus("Paid");
        } else {
            order.setPaymentStatus("UnPaid");
        }
        order.setUser(user);

        List<OrderItem> orderItems = new ArrayList<>();

        for (CartItem cartItem : user.getCart().getCartItems()) {
            // Set Data for Order Item
            OrderItem orderItem = new OrderItem();
            orderItem.setBook(cartItem.getBook());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setOrder(order);

            // Delete cart item
            this.cartItemRepository.deleteById(cartItem.getId());

            // Add Order Item to Order
            orderItems.add(orderItem);
        }
        order.setOrderItems(orderItems);

        // Update Cart
        user.getCart().setTotalPrice(0);
        user.getCart().setCartItems(null);
        this.cartRepository.save(user.getCart());

        return this.orderRepository.save(order);
    }
}
