package vn.toilamdev.bookmarket.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.toilamdev.bookmarket.constant.SystemConstant;
import vn.toilamdev.bookmarket.domain.Book;
import vn.toilamdev.bookmarket.domain.CartItem;
import vn.toilamdev.bookmarket.domain.Order;
import vn.toilamdev.bookmarket.domain.OrderItem;
import vn.toilamdev.bookmarket.domain.User;
import vn.toilamdev.bookmarket.dto.OrderDTO;
import vn.toilamdev.bookmarket.mapper.OrderMapper;
import vn.toilamdev.bookmarket.repository.BookRepository;
import vn.toilamdev.bookmarket.repository.CartItemRepository;
import vn.toilamdev.bookmarket.repository.CartRepository;
import vn.toilamdev.bookmarket.repository.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final BookRepository bookRepository;

    public OrderService(OrderRepository orderRepository, CartRepository cartRepository,
            CartItemRepository cartItemRepository, BookRepository bookRepository) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.bookRepository = bookRepository;
    }

    public Order createOrUpdateOrder(Order order) {
        return this.orderRepository.save(order);
    }

    public Order getOrderByPaymentRef(String paymentRef) {
        return this.orderRepository.findByPaymentRef(paymentRef);
    }

    public List<Order> getAllOrders(Pageable pageable) {
        Page<Order> page = this.orderRepository.findAll(pageable);
        return page.getContent();
    }

    public List<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    public Order getOrderById(long id) {
        return this.orderRepository.findById(id);
    }

    public List<Order> getListOrdersByUser(User user, Pageable pageable) {
        Page<Order> page = this.orderRepository.findByUser(user, pageable);
        return page.getContent();
    }

    public List<Order> getListOrdersByUser(User user) {
        return this.orderRepository.findByUser(user);
    }

    public long getCountOrder() {
        return this.orderRepository.count();
    }

    public Order createNewOrder(OrderDTO orderDTO, User user, String uuid) {
        // Mapping Data from OrderDTO to Order
        Order order = OrderMapper.mappingOrderDTO(orderDTO);
        List<OrderItem> orderItems = new ArrayList<>();

        order.setCreatedAt(new Date(System.currentTimeMillis()));
        order.setStatus(SystemConstant.ORDER_STATUS_PENDING);
        order.setUser(user);
        order.setPaymentStatus(SystemConstant.PAYMENT_STATUS_UNPAID);
        order.setPaymentRef(
                order.getPaymentMethod().equals(SystemConstant.PAYMENT_METHOD_COD) ? SystemConstant.PAYMENT_REF : uuid);

        if (orderDTO.getBookId() == 0) {

            for (CartItem cartItem : user.getCart().getCartItems()) {
                // Set Data for Order Item
                OrderItem orderItem = new OrderItem();
                orderItem.setBook(cartItem.getBook());
                orderItem.setQuantity(cartItem.getQuantity());
                orderItem.setTotalPrice(cartItem.getTotalPrice());
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
        } else {
            // Get Book By Id
            Book book = this.bookRepository.findById(orderDTO.getBookId());

            // Set Data for OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setBook(book);
            orderItem.setQuantity(orderDTO.getQuantity());
            orderItem.setTotalPrice(orderDTO.getTotalPrice());
            orderItem.setOrder(order);

            // Add OrderItem to List
            orderItems.add(orderItem);

            // Set List OrderItems for Order
            order.setOrderItems(orderItems);
        }

        return this.orderRepository.save(order);
    }

}
