package vn.toilamdev.bookmarket.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "publishers")
public class Publisher extends AbstractDomain {

    @NotBlank(message = "Bạn chưa nhập 'Tên' của nhà xuất bản")
    @Pattern(regexp = "^[\\p{L}\\d\\s.,-]+$", message = "Lỗi định dạng: 'Tên' không được chứa ký tự đặc biệt")
    @Size(min = 2, max = 200, message = "Số lượng ký tự quá ngắn hoặc quá dài: 'Tên' chỉ chứa từ 2 đến 200 ký tự")
    private String name;

    @NotBlank(message = "Bạn chưa nhập 'Địa Chỉ' của nhà xuất bản")
    @Pattern(regexp = "^[\\p{L}\\d\\s.,-/#()]+$", message = "Lỗi định dạng: 'Địa Chỉ' không chứa các ký tự đặc biệt")
    @Size(max = 500, message = "Địa chỉ quá dài: 'Địa Chỉ' chỉ tối đa 500 ký tự")
    private String address;

    @NotBlank(message = "Bạn chưa nhập 'Số Điện Thoại' của nhà xuất bản")
    @Pattern(regexp = "^(?:\\+84|0)(?:\\d{9}|\\d{10})$", message = "Lỗi định dạng: 'Số điện thoại' không hợp lệ")
    private String phoneNumber;

    @NotBlank(message = "Bạn chưa nhập địa chỉ 'Website' của nhà xuất bản")
    @Pattern(regexp = "^(https?:\\/\\/|ftp:\\/\\/|www\\.)[a-zA-Z0-9-]+(\\.[a-zA-Z]{2,})+([\\/\\w.-]*)*\\/?$", message = "Lỗi định dạng: địa chỉ 'Website' không hợp lệ")
    private String website;

    @OneToMany(mappedBy = Book_.PUBLISHER)
    private List<Book> books;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
