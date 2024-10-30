package vn.toilamdev.bookmarket.service;

import java.util.Date;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vn.toilamdev.bookmarket.constant.SystemConstant;
import vn.toilamdev.bookmarket.domain.Comment;
import vn.toilamdev.bookmarket.domain.Order;
import vn.toilamdev.bookmarket.domain.Role;
import vn.toilamdev.bookmarket.domain.User;
import vn.toilamdev.bookmarket.dto.UserDTO;
import vn.toilamdev.bookmarket.mapper.UserMapper;
import vn.toilamdev.bookmarket.repository.CartRepository;
import vn.toilamdev.bookmarket.repository.CommentRepository;
import vn.toilamdev.bookmarket.repository.OrderRepository;
import vn.toilamdev.bookmarket.repository.RoleRepository;
import vn.toilamdev.bookmarket.repository.UserRepository;
import vn.toilamdev.bookmarket.utils.UploadFile;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final UploadFile uploadFileService;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, CommentRepository commentRepository,
            OrderRepository orderRepository, CartRepository cartRepository, UploadFile uploadFileService,
            RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
        this.uploadFileService = uploadFileService;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
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

    public User getUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public User getUserByPhoneNumber(String phoneNumber) {
        return this.userRepository.findByPhoneNumber(phoneNumber);
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

    public User handleUpdateUser(User user, User currentUser, MultipartFile file) {
        if (!user.getRole().getName().equals(currentUser.getRole().getName())) {
            Role newRole = this.roleRepository.findByName(user.getRole().getName());
            currentUser.setRole(newRole);
        }

        currentUser.setFullName(user.getFullName());
        currentUser.setUsername(user.getUsername());
        currentUser.setAddress(user.getAddress());
        currentUser.setDateOfBirth(user.getDateOfBirth());

        if (file.getOriginalFilename() != "" || file.getOriginalFilename() != null) {
            String fileName = this.uploadFileService.handleSaveFile(file, SystemConstant.DIRECTORY_AVATAR);
            currentUser.setAvatar(fileName);
        }

        currentUser = this.userRepository.save(currentUser);
        return currentUser;
    }

    public User handleCreateUser(UserDTO userDTO, MultipartFile file) {
        Role role = this.roleRepository.findByName(userDTO.getRoleName());
        User newUser = UserMapper.mappingUserDTO(userDTO);

        newUser.setPassword(this.passwordEncoder.encode(userDTO.getPassword()));
        newUser.setRole(role);
        if (file.getOriginalFilename() == "" ||
                file.getOriginalFilename() == null) {
            newUser.setAvatar(SystemConstant.AVATAR_NAME_DEFAULT);
        } else {
            newUser.setAvatar(this.uploadFileService.handleSaveFile(file,
                    SystemConstant.DIRECTORY_AVATAR));
        }
        newUser.setCreatedAt(new Date(System.currentTimeMillis()));

        newUser = this.userRepository.save(newUser);

        return newUser;
    }
}
