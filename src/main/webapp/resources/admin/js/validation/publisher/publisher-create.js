$(document).ready(() => {

    //Save Time Out
    let typingTimer;
    const doneTypingInterval = 100;

    //Check Name
    $('#name').on('input blur', function () {
        const name = this.value;
        const nameRegex = /^[\p{L}\d\s.,-]+$/u;

        clearTimeout(typingTimer);
        typingTimer = setTimeout(() => {
            if (name.length === 0) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Bạn chưa nhập "Tên" của nhà xuất bản</div>').show();
            } else if (!nameRegex.test(name)) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Lỗi định dạng: "Tên" không được chứa ký tự đặc biệt</div>').show();
            } else if (name.length > 200 || name.length < 2) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Số lượng ký tự quá ngắn hoặc quá dài: "Tên" chỉ chứa từ 2 đến 200 ký tự</div>').show();
            } else {
                $(this).removeClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
            }
        }, doneTypingInterval);
    });

    //Check phone number
    $('#phoneNumber').on('input blur', function () {
        const phoneNumber = this.value;
        const phoneNumberRegex = /^(?:\+84|0)(?:\d{9}|\d{10})$/;

        if (phoneNumber.length === 0) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">Bạn chưa nhập "Số Điện Thoại" của nhà xuất bản</div>').show();
        } else if (!phoneNumberRegex.test(phoneNumber)) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">Lỗi định dạng: "Số điện thoại" không hợp lệ</div>').show();
        } else {
            $(this).removeClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
        }
    });

    //Check Link website
    $('#website').on('input blur', function () {
        const website = this.value;
        const websiteRegex = /^(https?:\/\/|ftp:\/\/|www\.)[a-zA-Z0-9-]+(\.[a-zA-Z]{2,})+([\/\w.-]*)*\/?$/;

        if (website.length === 0) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">Bạn chưa nhập địa chỉ "Website" của nhà xuất bản</div>').show();
        } else if (!websiteRegex.test(website)) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">Lỗi định dạng: địa chỉ "Website" không hợp lệ</div>').show();
        } else {
            $(this).removeClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
        }
    });

    //Check Address
    $('#address').on('input blur', function () {
        const address = this.value;
        const addressRegex = /^[\p{L}\d\s.,-/#()]+$/u;

        clearTimeout(typingTimer);
        typingTimer = setTimeout(() => {
            if (address.length === 0) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Bạn chưa nhập "Địa Chỉ" của nhà xuất bản</div>').show();
            } else if (!addressRegex.test(address)) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Lỗi định dạng: "Địa Chỉ" không chứa các ký tự đặc biệt</div>').show();
            } else if (address.length > 500) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Địa chỉ quá dài: "Địa Chỉ" chỉ tối đa 500 ký tự</div>').show();
            } else {
                $(this).removeClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
            }
        }, doneTypingInterval);
    });

    //Form Submit
    $("#formCreatePublisher").submit((event) => {
        event.preventDefault();
        var form = document.getElementById('formCreatePublisher');
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

    // Call API using FormData
    function sendAjaxRequest(formData) {
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8082/api/admin/publishers',
            data: formData,
            contentType: false,
            processData: false,
            success: function (response, textStatus, xhr) {
                alert("Thành công! Bạn đã tạo mới một nhà xuất bản.");
                window.location.href = '/admin/publishers';
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
                } else if (xhr.status === 409) {
                    alert("Tạo mới thất bại! Nhà xuất bản đã tồn tại.");
                } else {
                    alert('Lỗi khi tạo mới nhà xuất bản: ' + xhr.responseText);
                }
            }
        });
    }
});