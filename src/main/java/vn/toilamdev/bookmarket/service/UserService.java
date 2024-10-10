package vn.toilamdev.bookmarket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.toilamdev.bookmarket.domain.Comment;
import vn.toilamdev.bookmarket.domain.Order;
import vn.toilamdev.bookmarket.domain.User;
import vn.toilamdev.bookmarket.repository.CartRepository;
import vn.toilamdev.bookmarket.repository.CommentRepository;
import vn.toilamdev.bookmarket.repository.OrderRepository;
import vn.toilamdev.bookmarket.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;

    public UserService(UserRepository userRepository, CommentRepository commentRepository,
            OrderRepository orderRepository, CartRepository cartRepository) {
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
    }

    public User saveOrUpdateUser(User user) {
        return this.userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public void deleteUserById(long id) {
        this.userRepository.deleteById(id);
    }

    public User getUserById(long id) {
        return this.userRepository.findById(id);
    }

    public void handleDeleteUser(User user) {
        if (user.getComments().size() != 0) {
            for (Comment cmt : user.getComments()) {
                this.commentRepository.deleteById(cmt.getId());
            }
        }

        if (user.getOrders().size() != 0) {
            for (Order od : user.getOrders()) {
                this.orderRepository.deleteById(od.getId());
            }
        }

        if (user.getCart() != null) {
            this.cartRepository.deleteById(user.getCart().getId());
        }

        this.userRepository.deleteById(user.getId());
    }
}
