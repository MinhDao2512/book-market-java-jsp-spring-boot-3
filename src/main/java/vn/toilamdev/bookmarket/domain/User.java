package vn.toilamdev.bookmarket.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User extends AbstractDomain {

    @NotBlank(message = "'Tên Tài Khoản' không được để trống")
    @Pattern(regexp = "^(?![0-9])[\\w-]+$", message = "Lỗi định dạng: 'Tên Tài Khoản' không chứa ký tự đặc biệt, tiếng việt và khoảng trắng")
    @Size(min = 3, max = 20, message = "'Tên Tài Khoản' quá ngắn hoặc quá dài: Tối thiểu 3 và tối đa 20 ký tự")
    private String username;

    private String email;
    private String password;

    @NotBlank(message = "'Họ và Tên' không được để trống")
    @Pattern(regexp = "^[\\p{L}\\p{M}\\s'-]+$", message = "Lỗi định dạng: 'Họ và Tên' không chứa ký tự đặc biệt và chữ số")
    @Size(max = 100, message = "'Họ và Tên' quá dài: Tối đa 100 ký tự")
    private String fullName;

    @NotBlank(message = "'Địa Chỉ' không được để trống")
    @Pattern(regexp = "^[\\p{L}\\p{N}.,\\s/-]+,\\s*[\\p{L}\\p{N}.\\s-]+,\\s*[\\p{L}\\p{N}.\\s-]+,\\s*[\\p{L}\\p{N}.\\s-]+$", message = "Lỗi định dạng: 'Địa Chỉ' phải bao gồm: số nhà tên đường, tên phường, tên quận, tên thành phố")
    private String address;

    private String phoneNumber;

    @NotNull(message = "'Ngày Sinh' không được để trống")
    @Past(message = "'Ngày Sinh' không được lớn hơn ngày hiện tại")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    private String avatar;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = Comment_.USER)
    private List<Comment> comments;

    @OneToMany(mappedBy = Order_.USER)
    private List<Order> orders;

    @OneToOne(mappedBy = Cart_.USER)
    private Cart cart;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}
