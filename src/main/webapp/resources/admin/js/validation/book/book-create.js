$(document).ready(function (event) {

    //Save Time Out
    let typingTimer;
    const doneTypingInterval = 100;

    //Check ISBN
    $('#ISBN').on('input blur', function () {
        const iSBN = this.value;
        const iSBNRegex = /^(?:\d{9}X|\d{10}|(978|979)\d{10})$/;

        if (iSBN.length === 0) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">Bạn chưa nhập "ISBN"</div>').show();
        } else if (!iSBNRegex.test(iSBN)) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">"ISBN" không đúng định dạng</div>').show();
        } else {
            $(this).removeClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
        }
    });

    //Check Publication Date
    $('#publicationDate').on('input blur', function () {
        const publicationDate = this.value;
        const today = new Date();
        const inputValue = new Date(publicationDate);

        if (!publicationDate) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">Bạn chưa nhập "Ngày Sản Xuất"</div>').show();
        } else if (inputValue >= today) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">"Ngày Xuất Bản" không được lớn hơn ngày hiện tại</div>').show();
        } else {
            $(this).removeClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
        }
    });

    //Check Title
    $('#title').on('input blur', function () {
        const title = this.value;
        const titleRegex = /^[\p{L}\d\s'\-,:!?.()]+$/u;

        clearTimeout(typingTimer);
        typingTimer = setTimeout(() => {
            if (title.length === 0) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Bạn chưa nhập "Tiêu Đề"</div>').show();
            } else if (!titleRegex.test(title)) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">"Tiêu Đề" không được chứa ký tự đặc biệt</div>').show();
            } else {
                $(this).removeClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
            }
        }, doneTypingInterval);
    });

    //Check Categories
    $('#categories').on('change', function () {
        const categories = this.value;

        if (categories.length === 0) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">Bạn chưa chọn "Thể Loại"</div>').show();
        } else {
            $(this).removeClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
        }
    });

    //Check Quantity
    $('#quantity').on('input blur', function () {
        const quantity = this.value;
        const quantityRegex = /^\d+$/;

        if (quantity.length === 0) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">Bạn chưa nhập "Số Lượng"</div>').show();
        } else if (!quantityRegex.test(quantity)) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">Lỗi đầu vào: "Số Lượng" chỉ chứa các ký tự số và có giá trị lớn hơn hoặc bằng 0</div>').show();
        } else {
            $(this).removeClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
        }
    });

    //Check Price
    $('#price').on('input blur', function () {
        const price = this.value;
        const priceRegex = /^\d+$/;

        if (price.length === 0) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">Bạn chưa nhập "Giá Bán"</div>').show();
        } else if (!priceRegex.test(price)) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">Lỗi đầu vào: "Giá Bán" chỉ chứa ký tự số và có giá trị lớn hơn hoặc bằng 0</div>').show();
        } else {
            $(this).removeClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
        }
    });

    //Check State
    $('#state').on('change blur', function () {
        const state = this.value;

        if (state === "") {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">Bạn chưa chọn "Tình Trạng"</div>').show();
        } else {
            $(this).removeClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
        }
    });

    //Check Publishing Company
    $('#publishingCompany').on('input blur', function () {
        const publishingCompany = this.value;
        const publishingCompanyRegex = /^[\p{L}\p{N}\s]+$/u;

        clearTimeout(typingTimer);
        typingTimer = setTimeout(() => {
            if (publishingCompany.length === 0) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Bạn chưa nhập tên "Công Ty Phát Hành"</div>').show();
            } else if (!publishingCompanyRegex.test(publishingCompany)) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Lỗi định dạng: tên "Công Ty Phát Hành" không được chứa ký tự đặc biệt</div>').show();
            } else {
                $(this).removeClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
            }
        }, doneTypingInterval);
    });

    //Check Size
    $('#size').on('input blur', function () {
        const size = this.value;
        const sizeRegex = /^\d+(\.\d+)?\s*x\s*\d+(\.\d+)?\s*(cm|inch?)$/i;

        if (size.length === 0) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">Bạn chưa nhập "Kích Thước"</div>').show();
        } else if (!sizeRegex.test(size)) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">Lỗi định dạng: "Kích Thước" chứa ký tự đặc biệt hoặc thiếu đơn vị cm | inch</div>').show();
        } else {
            $(this).removeClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
        }
    });

    //Check Translator
    $('#translator').on('input blur', function () {
        const translator = this.value;
        const translatorRegex = /^[\p{L}\s',.\-]+$/u;

        clearTimeout(typingTimer);
        typingTimer = setTimeout(() => {
            if (translator.length === 0) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Bạn chưa nhập tên "Dịch Giả"</div>').show();
            } else if (!translatorRegex.test(translator)) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Lỗi định dạng: tên "Dịch Giả" không được chứa ký tự đặc biệt và số</div>').show();
            } else {
                $(this).removeClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
            }
        }, doneTypingInterval);
    });

    //Check CoverType
    $('#coverType').on('change', function () {
        const coverType = this.value;

        if (coverType === "") {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">Bạn chưa chọn "Loại Bìa"</div>').show();
        } else {
            $(this).removeClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
        }
    });

    //Check Number Of Pages
    $('#numberOfPages').on('input blur', function () {
        const numberOfPages = this.value;
        const numberOfPagesRegex = /^([2-9]\d*|[1-9]\d{2,})$/;

        if (numberOfPages.length === 0) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">Bạn chưa nhập "Số Trang"</div>').show();
        } else if (!numberOfPagesRegex.test(numberOfPages)) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">Lỗi ràng buộc: "Số trang" chỉ chứa các chữ số và phải lớn hơn hoặc bằng 20 trang</div>').show();
        } else {
            $(this).removeClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
        }
    });

    //Check Description
    $('#description').on('input blur', function () {
        const description = this.value;

        if (description.length === 0) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">Bạn chưa nhập "Mô Tả Sản Phẩm"</div>').show();
        } else {
            $(this).removeClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
        }
    });

    $('#selectAuthor').on('change', function () {
        const selectAuthor = this.value;

        if (selectAuthor === "") {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">Bạn chưa chọn "Tác Giả"</div>').show();
        } else {
            $(this).removeClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();

            if (selectAuthor === "OTHER") {
                $('.other-author').show();
                $('#authorName').prop('required', true).after('<div class="invalid-feedback">Bạn chưa nhập "Tên" của tác giả</div>');
                $('#birthDate').prop('required', true).after('<div class="invalid-feedback">Bạn chưa nhập "Ngày Sinh" của tác giả</div>');
                $('#nationality').prop('required', true).after('<div class="invalid-feedback">Bạn chưa nhập "Quốc Tịch" của tác giả</div>');
                $('#biography').prop('required', true).after('<div class="invalid-feedback">Bạn chưa nhập "Tiểu Sử" của tác giả</div>');
            }
            else {
                $('.other-author').hide();
                $('#authorName').prop('required', false).nextAll('.invalid-feedback').remove();
                $('#birthDate').prop('required', false).nextAll('.invalid-feedback').remove();
                $('#nationality').prop('required', false).nextAll('.invalid-feedback').remove();
                $('#biography').prop('required', false).nextAll('.invalid-feedback').remove();
            }
        }
    });

    //Check Author Name
    $('#authorName').on('input blur', function () {
        const authorName = this.value;
        const authorNameRegex = /^\p{L}+(?:[\s-]\p{L}+)*$/u;

        clearTimeout(typingTimer);
        typingTimer = setTimeout(() => {
            if (authorName.length === 0) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Bạn chưa nhập "Họ và Tên" của tác giả</div>').show();
            } else if (!authorNameRegex.test(authorName)) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Lỗi định dạng: "Họ và Tên" chứa số, ký tự đặc biệt hoặc thừa khoảng trắng</div>').show();
            } else if (authorName.length > 100) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">"Họ và Tên" quá dài: Tối đa 100 ký tự</div>').show();
            } else {
                $(this).removeClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
            }
        }, doneTypingInterval);
    });

    //Check Birth Date
    $('#birthDate').on('input blur', function () {
        const birthDate = new Date(this.value);
        const today = new Date();

        if (!this.value) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">Bạn chưa nhập "Ngày Sinh" của tác giả</div>').show();
        } else if (birthDate > today) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">"Ngày Sinh" không được lớn hơn ngày hiện tại</div>').show();
        } else {
            $(this).removeClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
        }
    });

    //Check Nationality
    $('#nationality').on('input blur', function () {
        const nationality = this.value;
        const nationalityRegex = /^[\p{L}\s-]+$/u;

        clearTimeout(typingTimer);
        typingTimer = setTimeout(() => {
            if (nationality.length === 0) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Bạn chưa nhập "Quốc Tịch" của tác giả</div>').show();
            } else if (!nationalityRegex.test(nationality)) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Lỗi định dạng: "Quốc Tịch" không được chứa ký tự đặc biệt và số</div>').show();
            } else {
                $(this).removeClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
            }
        }, doneTypingInterval);
    });

    //Check Biography
    $('#biography').on('input blur', function () {
        const biography = this.value;

        if (biography.length === 0) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">Bạn chưa nhập "Tiểu Sử" của tác giả</div>').show();
        } else {
            $(this).removeClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
        }
    });

    //Check Publisher
    $('#selectPublisher').on('change blur', function () {
        const publisher = this.value;

        if (publisher === "") {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">Bạn chưa chọn "Nhà Xuất Bản"</div>').show();
        } else {
            $(this).removeClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
        }
    });

    //Check Images
    $('#bookFiles').on('change', function () {
        const bookFiles = this.files;

        if (bookFiles.length === 0) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">Bạn chưa chọn "Hình Mô Tả"</div>').show();
        } else {
            $(this).removeClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
        }
    });

    $('#formCreateBook').submit(function (event) {
        event.preventDefault();
        var form = document.getElementById('formCreateBook');
        var formData = new FormData(form);
        var inValid = false;

        $("input[required], select[required], textarea[required]").each(function () {
            // check exists div.invalid-feedback 
            if ($(this).next('.invalid-feedback').length) {
                inValid = true;
            }
        });

        if (inValid) {
            alert('Có lỗi xảy ra: " BẠN CHƯA ĐIỀN ĐẦY ĐỦ THÔNG TIN HOẶC THÔNG TIN SAI ĐỊNH DẠNG !"');
            event.stopPropagation()
            $("input[required], select[required], textarea[required]").each(function () {
                if ($(this).next('.invalid-feedback').length) {
                    $(this).addClass('is-invalid');
                    $(this).next('.invalid-feedback').show();
                }
            });
        } else {
            sendAjaxRequest(formData);
        }
    });

    function sendAjaxRequest(formData) {
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8082/api/admin/books',
            data: formData,
            contentType: false,
            processData: false,
            success: function (response) {
                alert('Bạn đã thêm mới sản phẩm thành công!');
                window.location.href = '/admin/books?page=1';
            },
            error: function (xhr, status, error) {
                if (xhr.status === 400) {
                    alert('Lỗi phía Server: Thông tin không hợp lệ hoặc đã tồn tại !')
                    // Clear previous errors
                    $('.is-invalid').removeClass('is-invalid');
                    $('.invalid-feedback').remove();

                    // Display validation errors
                    var errors = JSON.parse(xhr.responseText);
                    Object.keys(errors).forEach(function (key) {
                        var inputField = $('#' + key);
                        inputField.addClass('is-invalid');
                        inputField.after('<div class="invalid-feedback">' + errors[key] + '</div>').show();
                    });
                } else {
                    alert('Lỗi khi tạo mới sách: ' + xhr.responseText);
                }
            }
        });
    }

    // Preview Avatar
    $('#bookFiles').change(
        function (e) {
            const previewContainer = $("#imagePreviewContainer");
            previewContainer.html("");

            [...e.target.files].forEach((file, index) => {
                const imgURL = URL.createObjectURL(file);
                $('<img>', {
                    src: imgURL,
                    alt: "Avatar Preview",
                    title: `Avatar Preview ${index + 1}`,
                    css: { maxHeight: '200px', margin: '10px' }
                }).appendTo(previewContainer);
            });
        }
    );
});