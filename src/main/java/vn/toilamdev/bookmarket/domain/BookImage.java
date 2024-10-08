package vn.toilamdev.bookmarket.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_images")
public class BookImage extends AbstractDomain {
    private String name;
    private Integer orderImage;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(Integer orderImage) {
        this.orderImage = orderImage;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
