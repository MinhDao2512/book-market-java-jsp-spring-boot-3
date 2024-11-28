package vn.toilamdev.bookmarket.service;

import org.springframework.stereotype.Service;

import vn.toilamdev.bookmarket.domain.Cart;
import vn.toilamdev.bookmarket.repository.CartRepository;

@Service
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart saveOrUpdateCart(Cart cart) {
        return this.cartRepository.save(cart);
    }
}
