package vn.toilamdev.bookmarket.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "book_authorship")
public class BookAuthorship extends AbstractDomain {
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    private String roleAuthor;
    private Integer orderAuthor;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getRoleAuthor() {
        return roleAuthor;
    }

    public void setRoleAuthor(String roleAuthor) {
        this.roleAuthor = roleAuthor;
    }

    public Integer getOrderAuthor() {
        return orderAuthor;
    }

    public void setOrderAuthor(Integer orderAuthor) {
        this.orderAuthor = orderAuthor;
    }

}
