package vn.toilamdev.bookmarket.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category extends AbstractDomain {
    private String name;
    private String description;

    @OneToMany(mappedBy = BookCategorization_.CATEGORY)
    private List<BookCategorization> bookCategorizations;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<BookCategorization> getBookCategorizations() {
        return bookCategorizations;
    }

    public void setBookCategorizations(List<BookCategorization> bookCategorizations) {
        this.bookCategorizations = bookCategorizations;
    }

}
