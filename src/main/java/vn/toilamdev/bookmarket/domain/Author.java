package vn.toilamdev.bookmarket.domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "authors")
public class Author extends AbstractDomain {
    private String name;
    private String biography;
    private LocalDate birthDate;
    private String nationality;

    @OneToMany(mappedBy = BookAuthorship_.AUTHOR)
    private List<BookAuthorship> bookAuthorship;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<BookAuthorship> getBookAuthorship() {
        return bookAuthorship;
    }

    public void setBookAuthorship(List<BookAuthorship> bookAuthorship) {
        this.bookAuthorship = bookAuthorship;
    }

}
