package vn.toilamdev.bookmarket.controller.rest;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import vn.toilamdev.bookmarket.domain.Cart;
import vn.toilamdev.bookmarket.domain.CartItem;
import vn.toilamdev.bookmarket.service.CartItemService;
import vn.toilamdev.bookmarket.service.CartService;

class CartItemDTO {
    private long cartItemId;
    private int quantity;
    private double totalCartPrice;
    private double totalCartItemPrice;

    public long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalCartPrice() {
        return totalCartPrice;
    }

    public void setTotalCartPrice(double totalCartPrice) {
        this.totalCartPrice = totalCartPrice;
    }

    public double getTotalCartItemPrice() {
        return totalCartItemPrice;
    }

    public void setTotalCartItemPrice(double totalCartItemPrice) {
        this.totalCartItemPrice = totalCartItemPrice;
    }

}

@RestController
@RequestMapping("/api/cart-item")
public class CartItemRestController {
    private final CartItemService cartItemService;
    private final CartService cartService;

    public CartItemRestController(CartItemService cartItemService, CartService cartService) {
        this.cartItemService = cartItemService;
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<Object> updateCartItem(@RequestBody CartItemDTO cartItemDTO, HttpServletRequest request) {
        // Get Session
        HttpSession session = request.getSession();

        // Update Cart Item
        CartItem cartItem = this.cartItemService.getCartItemById(cartItemDTO.getCartItemId());
        cartItem.setQuantity(cartItemDTO.getQuantity());
        cartItem.setTotalPrice(cartItemDTO.getTotalCartItemPrice());
        cartItem = this.cartItemService.saveOrUpdateCartItem(cartItem);

        // Update Cart
        Cart currentCart = this.cartService.getCartById(cartItem.getCart().getId());
        currentCart.setTotalPrice(cartItemDTO.getTotalCartPrice());
        currentCart = this.cartService.saveOrUpdateCart(currentCart);

        session.setAttribute("totalCartPrice", cartItemDTO.getTotalCartPrice());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteCartItem(@RequestBody CartItemDTO cartItemDTO, HttpServletRequest request) {
        CartItem currentCartItem = this.cartItemService.getCartItemById(cartItemDTO.getCartItemId());

        if (currentCartItem != null) {
            // update cart
            Cart currentCart = this.cartService.getCartById(currentCartItem.getCart().getId());
            currentCart.setTotalPrice(currentCart.getTotalPrice() - currentCartItem.getTotalPrice());
            currentCart = this.cartService.saveOrUpdateCart(currentCart);

            // delete Cart Item
            this.cartItemService.deleteCartItemById(currentCartItem.getId());

            // update session
            HttpSession session = request.getSession();
            session.setAttribute("cartCount", currentCart.getCartItems().size() - 1);
            session.setAttribute("totalCartPrice", currentCart.getTotalPrice());

            return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("message", "success"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("message", "Cart Item already exists"));
        }
    }
}