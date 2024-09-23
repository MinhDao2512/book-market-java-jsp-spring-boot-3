package vn.toilamdev.bookmarket.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "carts")
public class Cart extends AbstractDomain {
    @OneToMany(mappedBy = CartItem_.CART)
    private List<CartItem> cartItems;

    @OneToOne(mappedBy = User_.CART)
    @JoinColumn(name = "user_id")
    private User user;

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
