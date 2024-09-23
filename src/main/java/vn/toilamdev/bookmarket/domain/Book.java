package vn.toilamdev.bookmarket.domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book extends AbstractDomain {
    private String title;
    private String ISBN;
    private String description;
    private Double price;
    private LocalDate publicationDate;
    private String condition;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @OneToMany(mappedBy = BookAuthorship_.BOOK)
    private List<BookAuthorship> bookAuthorship;

    @OneToMany(mappedBy = Comment_.BOOK)
    private List<Comment> comments;

    @OneToMany(mappedBy = OrderItem_.BOOK)
    private List<OrderItem> orderItems;

    @OneToMany(mappedBy = CartItem_.BOOK)
    private List<CartItem> cartItems;

    @OneToMany(mappedBy = BookCategorization_.BOOK)
    private List<BookCategorization> bookCategorizations;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<BookAuthorship> getBookAuthorship() {
        return bookAuthorship;
    }

    public void setBookAuthorship(List<BookAuthorship> bookAuthorship) {
        this.bookAuthorship = bookAuthorship;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public List<BookCategorization> getBookCategorizations() {
        return bookCategorizations;
    }

    public void setBookCategorizations(List<BookCategorization> bookCategorizations) {
        this.bookCategorizations = bookCategorizations;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", ISBN=" + ISBN + ", description=" + description + ", price=" + price
                + ", publicationDate=" + publicationDate + ", condition=" + condition + ", quantity=" + quantity
                + ", publisher=" + publisher + ", bookAuthorship=" + bookAuthorship + ", comments=" + comments
                + ", orderItems=" + orderItems + ", cartItems=" + cartItems + ", bookCategorizations="
                + bookCategorizations + "]";
    }

}
