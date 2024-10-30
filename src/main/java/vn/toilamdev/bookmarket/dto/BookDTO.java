package vn.toilamdev.bookmarket.dto;

import java.util.List;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import vn.toilamdev.bookmarket.domain.Author;
import vn.toilamdev.bookmarket.validation.UniqueAuthor;

public class BookDTO {
    @NotBlank(message = "Bạn chưa nhập 'ISBN'")
    @Pattern(regexp = "^(?:\\d{9}X|\\d{10}|(978|979)\\d{10})$", message = "'ISBN' không đúng định dạng !")
    private String ISBN;

    @NotNull(message = "Bạn chưa nhập 'Ngày Xuất Bản' !")
    @Past(message = "'Ngày Xuất Bản' không được lớn hơn ngày hiện tại !")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publicationDate;

    @NotBlank(message = "Bạn chưa nhập 'Tiêu Đề' !")
    @Pattern(regexp = "^[\\p{L}\\d\\s'\\-,:!?.()]+$", message = "'Tiêu Đề' không được chứa ký tự đặc biệt !")
    private String title;

    @NotBlank(message = "Bạn chưa nhập 'Số Lượng' !")
    @Pattern(regexp = "^\\d+$", message = "Lỗi đầu vào: 'Số Lượng' chỉ chứa ký tự số và có giá trị lớn hơn hoặc bằng 0 !")
    private String quantity;

    @NotBlank(message = "Bạn chưa nhập 'Giá Bán' !")
    @Pattern(regexp = "^\\d+$", message = "Lỗi đầu vào: 'Giá Bán' chỉ chứa ký tự số và có giá trị lớn hơn hoặc bằng 0 !")
    private String price;

    @NotBlank(message = "Bạn chưa chọn 'Tình Trạng' !")
    private String state;

    @NotNull(message = "Bạn chưa chọn 'Thể Loại' !")
    private List<String> categories;

    @NotBlank(message = "Bạn chưa nhập 'Mô Tả Sản Phẩm' !")
    private String description;

    @NotBlank(message = "Bạn chưa chọn 'Tác Giả'")
    private String authorDefault;

    @NotBlank(message = "Bạn chưa chọn 'Nhà Xuất Bản' !")
    private String publisher;

    @NotBlank(message = "Bạn chưa nhập tên 'Công Ty Phát Hành' !")
    @Pattern(regexp = "^[\\p{L}\\p{N}\\s]+$", message = "Lỗi định dạng: tên 'Công Ty Phát Hành' không được chứa ký tự đặc biệt !")
    private String publishingCompany;

    @NotBlank(message = "Bạn chưa nhập 'Kích Thước' !")
    @Pattern(regexp = "^\\d+(\\.\\d+)?\\s*x\\s*\\d+(\\.\\d+)?\\s*(cm|inch?)$", message = "Lỗi định dạng: 'Kích Thước' chứa ký tự đặc biệt hoặc thiếu đơn vị cm | inch !")
    private String size;

    @NotBlank(message = "Bạn chưa nhập tên 'Dịch Giả' !")
    @Pattern(regexp = "^[\\p{L}\\s',.\\-]+$", message = "Lỗi định dạng: tên 'Dịch Giả' không được chứa ký tự đặc biệt và số !")
    private String translator;

    @NotBlank(message = "Bạn chưa chọn 'Loại Bìa' !")
    private String coverType;

    @NotBlank(message = "Bạn chưa nhập 'Số Trang' !")
    @Pattern(regexp = "^([2-9]\\d*|[1-9]\\d{2,})$", message = "Lỗi ràng buộc: 'Số trang' chỉ chứa các chữ số và phải lớn hơn hoặc bằng 20 trang !")
    private String numberOfPages;

    @UniqueAuthor
    private Author newAuthor;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorDefault() {
        return authorDefault;
    }

    public void setAuthorDefault(String authorDefault) {
        this.authorDefault = authorDefault;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
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

    public String getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(String numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Author getNewAuthor() {
        return newAuthor;
    }

    public void setNewAuthor(Author newAuthor) {
        this.newAuthor = newAuthor;
    }

}
