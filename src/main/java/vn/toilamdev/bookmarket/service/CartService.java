package vn.toilamdev.bookmarket.service;

import org.springframework.stereotype.Service;

import vn.toilamdev.bookmarket.domain.Book;
import vn.toilamdev.bookmarket.domain.Cart;
import vn.toilamdev.bookmarket.domain.CartItem;
import vn.toilamdev.bookmarket.domain.User;
import vn.toilamdev.bookmarket.repository.BookRepository;
import vn.toilamdev.bookmarket.repository.CartItemRepository;
import vn.toilamdev.bookmarket.repository.CartRepository;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final BookRepository bookRepository;

    public CartService(CartRepository cartRepository, CartItemRepository cartItemRepository,
            BookRepository bookRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.bookRepository = bookRepository;
    }

    public Cart saveOrUpdateCart(Cart cart) {
        return this.cartRepository.save(cart);
    }

    public Cart addToCart(User currentUser, Book book, int bookCount) {
        // Update quantity for book
        book.setQuantity(book.getQuantity() - bookCount);
        book = this.bookRepository.save(book);

        int countCartItems = currentUser.getCart().getCartItems().size();
        // Check Cart exists
        if (countCartItems != 0) {
            return null;
        } else {
            // Create new cartItem
            CartItem cartItem = new CartItem();
            cartItem.setBook(book);
            cartItem.setCart(currentUser.getCart());
            cartItem.setQuantity(bookCount);
            cartItem.setTotalPrice(book.getPrice() * cartItem.getQuantity());
            cartItem = this.cartItemRepository.save(cartItem);

            // Update Cart
            currentUser.getCart().getCartItems().add(cartItem);
            currentUser.getCart().setTotalPrice(cartItem.getTotalPrice());
            Cart newCart = this.cartRepository.save(currentUser.getCart());

            return newCart;
        }
    }
}
