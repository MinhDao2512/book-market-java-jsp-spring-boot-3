package vn.toilamdev.bookmarket.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
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

    @Column(columnDefinition = "MEDIUMTEXT")
    private String description;

    private Double price;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publicationDate;

    private String state;
    private Integer quantity;
    private String publishingCompany;
    private String size;
    private String translator;
    private String coverType;
    private Integer numberOfPages;
    private Integer isActive;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(mappedBy = Comment_.BOOK)
    private List<Comment> comments;

    @OneToMany(mappedBy = OrderItem_.BOOK)
    private List<OrderItem> orderItems;

    @OneToMany(mappedBy = CartItem_.BOOK)
    private List<CartItem> cartItems;

    @OneToMany(mappedBy = BookCategorization_.BOOK)
    private List<BookCategorization> bookCategorizations;

    @OneToMany(mappedBy = BookImage_.BOOK)
    private List<BookImage> bookImages;

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

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(String publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getCoverType() {
        return coverType;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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

    public List<BookImage> getBookImages() {
        return bookImages;
    }

    public void setBookImages(List<BookImage> bookImages) {
        this.bookImages = bookImages;
    }

}
