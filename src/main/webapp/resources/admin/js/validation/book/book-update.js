$(document).ready(function (event) {

    //Save Time Out
    let typingTimer;
    const doneTypingInterval = 100;

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

    $('#formCreateBook').submit(function (event) {
        event.preventDefault();
        var form = document.getElementById('formCreateBook');
        var formData = new FormData(form);
        var id = $('#bookId').val();
        var inValid = false;

        $(".validate").each(function () {
            // check exists div.invalid-feedback 
            if ($(this).next('.invalid-feedback').length) {
                inValid = true;
            }
        });

        if (inValid) {
            alert('Có lỗi xảy ra: " BẠN CHƯA ĐIỀN ĐẦY ĐỦ THÔNG TIN HOẶC THÔNG TIN SAI ĐỊNH DẠNG !"');
            event.stopPropagation()
            $(".validate").each(function () {
                if ($(this).next('.invalid-feedback').length) {
                    $(this).addClass('is-invalid');
                    $(this).next('.invalid-feedback').show();
                }
            });
        } else {
            sendAjaxRequest(formData, id);
        }
    });

    function sendAjaxRequest(formData, id) {
        $.ajax({
            type: 'PUT',
            url: 'http://localhost:8082/api/admin/books/' + id,
            data: formData,
            contentType: false,
            processData: false,
            success: function (response) {
                alert('Bạn đã cập nhật sản phẩm thành công!');
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
                } else if (xhr.status === 404) {
                    alert('Lỗi khi cập nhật sản phẩm: Thông tin cập nhật không tồn tại!');
                    window.location.href = '/admin/books';
                } else {
                    alert('Lỗi khi cập nhật sản phẩm: ' + xhr.responseText);
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