package vn.toilamdev.bookmarket.service;

import org.springframework.stereotype.Service;

import vn.toilamdev.bookmarket.domain.CartItem;
import vn.toilamdev.bookmarket.repository.CartItemRepository;

@Service
public class CartItemService {
    private final CartItemRepository cartItemRepository;

    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public CartItem saveOrUpdateCartItem(CartItem cartItem) {
        return this.cartItemRepository.save(cartItem);
    }

    public CartItem getCartItemById(long cartItemId) {
        return this.cartItemRepository.findById(cartItemId);
    }
}
