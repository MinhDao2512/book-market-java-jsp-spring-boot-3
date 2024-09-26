package vn.toilamdev.bookmarket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.toilamdev.bookmarket.domain.User;
import vn.toilamdev.bookmarket.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveOrUpdateUser(User user) {
        return this.userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }
}
