package vn.toilamdev.bookmarket.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "categories")
public class Category extends AbstractDomain {

    @NotBlank(message = "Bạn chưa nhập 'Tên' của thể loại")
    @Pattern(regexp = "^[\\p{L}\\s,-]+$", message = "Lỗi định dạng: 'Tên' thể loại không chứa ký tự đặc biệt, chữ số")
    @Size(max = 50, message = "'Tên' của thể loại quá dài: Tối đa 50 ký tự")
    private String name;

    @NotBlank(message = "Bạn chưa nhập 'Mô Tả' của thể loại")
    @Pattern(regexp = "^[\\p{L}\\s,-]+$", message = "Lỗi định dạng: 'Mô Tả' thể loại không chứa ký tự đặc biệt và chữ số")
    @Size(max = 100, message = "'Mô Tả' của thể loại quá dài: Tối đa 100 ký tự")
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
