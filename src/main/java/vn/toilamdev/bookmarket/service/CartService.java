package vn.toilamdev.bookmarket.service;

import java.util.List;

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

    public Cart getCartById(long id) {
        return this.cartRepository.findById(id);
    }

    // Add Item To Cart
    public Cart addToCart(User currentUser, Book book, int bookCount) {
        // Update quantity for book
        book.setQuantity(book.getQuantity() - bookCount);
        book = this.bookRepository.save(book);

        // check
        int countCart = currentUser.getCart().getCartItems().size();

        // Check Cart exists
        if (countCart != 0) {
            int indexCartItem = checkCartItemExists(book, currentUser.getCart().getCartItems());

            if (indexCartItem != -1) {
                int newQuantity = currentUser.getCart().getCartItems().get(indexCartItem).getQuantity() + bookCount;

                // Update Cart Item
                currentUser.getCart().getCartItems().get(indexCartItem).setQuantity(newQuantity);
                currentUser.getCart().getCartItems().get(indexCartItem).setTotalPrice(newQuantity * book.getPrice());
                this.cartItemRepository.save(currentUser.getCart().getCartItems().get(indexCartItem));

                currentUser.getCart()
                        .setTotalPrice(currentUser.getCart().getTotalPrice() + (bookCount * book.getPrice()));
                return this.cartRepository.save(currentUser.getCart());
            } else {
                // Create new Cart Item
                CartItem cartItem = updateDataCartItem(book, bookCount, currentUser.getCart());
                cartItem = this.cartItemRepository.save(cartItem);

                // Update Cart
                currentUser.getCart().getCartItems().add(cartItem);
                currentUser.getCart().setTotalPrice(cartItem.getTotalPrice() + currentUser.getCart().getTotalPrice());

                return this.cartRepository.save(currentUser.getCart());
            }
        } else {
            // Create new cartItem
            CartItem cartItem = updateDataCartItem(book, bookCount, currentUser.getCart());
            cartItem = this.cartItemRepository.save(cartItem);

            // Update Cart
            currentUser.getCart().getCartItems().add(cartItem);
            currentUser.getCart().setTotalPrice(cartItem.getTotalPrice());

            return this.cartRepository.save(currentUser.getCart());
        }
    }

    private static int checkCartItemExists(Book book, List<CartItem> cartItems) {
        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).getBook().getId() == book.getId()) {
                return i;
            }
        }
        return -1;
    }

    private static CartItem updateDataCartItem(Book book, int bookCount, Cart cart) {
        CartItem cartItem = new CartItem();
        cartItem.setBook(book);
        cartItem.setCart(cart);
        cartItem.setQuantity(bookCount);
        cartItem.setTotalPrice(book.getPrice() * cartItem.getQuantity());

        return cartItem;
    }
}
