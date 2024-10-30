package vn.toilamdev.bookmarket.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "authors")
public class Author extends AbstractDomain {

    @NotBlank(message = "Bạn chưa nhập 'Họ và Tên' tác giả")
    @Pattern(regexp = "^\\p{L}+(?:[\\s-]\\p{L}+)*$", message = "Lỗi định dạng: 'Họ và Tên' không chứa số, ký tự đặc biệt hoặc thừa khoảng trắng")
    @Size(min = 1, max = 100, message = "'Họ và Tên' quá dài: Tối đa 100 ký tự")
    private String name;

    @NotBlank(message = "Bạn chưa nhập 'Tiểu Sử' của tác giả")
    private String biography;

    @NotNull(message = "Bạn chưa nhập 'Ngày Sinh' của tác giả")
    @Past(message = "'Ngày Sinh' không được lớn hơn ngày hiện tại")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @NotBlank(message = "Bạn chưa nhập 'Quốc Tịch'")
    @Pattern(regexp = "^[\\p{L}\\s-]+$", message = "Lỗi định dạng: 'Quốc Tịch' không được chứa ký tự đặc biệt và số")
    private String nationality;

    @OneToMany(mappedBy = Book_.AUTHOR)
    private List<Book> books;

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
