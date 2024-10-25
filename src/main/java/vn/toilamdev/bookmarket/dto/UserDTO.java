package vn.toilamdev.bookmarket.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import vn.toilamdev.bookmarket.validation.UniqueEmail;
import vn.toilamdev.bookmarket.validation.UniquePhoneNumber;

public class UserDTO {
    @NotBlank(message = "'Tên' không được để trống !")
    @Size(max = 30, message = "'Tên' không được vượt quá 30 ký tự !")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "'Tên' không hợp lệ: Không được chứa ký tự đặc biệt, chữ số và tiếng việt !")
    private String firstName;

    @NotBlank(message = "'Họ và Tên đêm' không được để trống !")
    @Size(max = 100, message = "'Họ và Tên đệm' không được vượt quá 100 ký tự !")
    @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "'Họ và Tên đệm' không hợp lệ: Không được chứa ký tự đặc biệt, chữ số và tiếng việt !")
    private String lastName;

    @NotBlank(message = "'Email' không được để trống !")
    @Email(message = "Địa chỉ 'Email' không hợp lệ !")
    @UniqueEmail(message = "Địa chỉ 'Email' đã tồn tại. Hãy nhập địa chỉ 'Email' khác !")
    private String email;

    @NotBlank(message = "'Mật khẩu' không được để trống !")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*\\W).{8,}$", message = "'Mật khẩu' phải chứa ít nhất 8 ký tự, bao gồm chữ thường, chữ hoa, số và ký tự đặc biệt")
    private String password;

    @NotBlank(message = "'Số Điện thoại' không được để trống !")
    @Pattern(regexp = "^(\\+84|0)(\\s?\\d{3})(\\s?\\d{3})(\\s?\\d{3})$", message = "'Số Điện Thoại' không hợp lệ !")
    @UniquePhoneNumber(message = "'Số điện thoại' đã tồn tại. Hãy nhập 'Số điện thoại' khác !")
    private String phoneNumber;

    @Pattern(regexp = "^[0-9a-zA-Z\\-\\/\\s]*$", message = "'Số nhà' không hợp lệ !")
    private String houseNumber;

    @NotBlank(message = "'Tên Đường' không được để trống !")
    @Pattern(regexp = "^[a-zA-Z\\s\\-\\.]+$", message = "'Tên Đường' không hợp lệ !")
    private String street;

    @NotBlank(message = "'Tên Phường | Xã' không được để trống !")
    @Pattern(regexp = "^[a-zA-Z\\s\\-\\,\\.]+$", message = "'Tên Phường | Xã' không hợp lệ !")
    private String ward;

    @NotBlank(message = "'Tên Quận | Huyện' không được để trống !")
    @Pattern(regexp = "^[a-zA-Z0-9\\s\\-\\,\\.]+$", message = "'Tên Quận | Huyện' không hợp lệ !")
    private String district;

    @NotBlank(message = "'Tên Tỉnh | Thành phố' không được để trống !")
    @Pattern(regexp = "^[a-zA-Z\\s\\-\\,\\.]+$", message = "'Tên Tỉnh | Thành phố' không hợp lệ !")
    private String city;

    @NotNull(message = "'Ngày sinh' không được NULL !")
    @Past(message = "'Ngày sinh' không được phép lớn hơn ngày hiện tại !")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @NotBlank(message = "'Vai trò' không được để trống !")
    private String roleName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
