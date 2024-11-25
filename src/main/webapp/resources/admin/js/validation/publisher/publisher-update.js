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
    $("#formUpdatePublisher").submit((event) => {
        event.preventDefault();
        var formData = new FormData(document.getElementById('formUpdatePublisher'));
        var object = {};
        formData.forEach((value, key) => object[key] = value);

        var publisherId = $('#publisherId').val();
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
            sendAjaxRequest(JSON.stringify(object), publisherId);
        }
    });

    // Call API using FormData
    function sendAjaxRequest(formData, publisherId) {
        $.ajax({
            type: 'PUT',
            url: 'http://localhost:8082/api/admin/publishers/' + publisherId,
            data: formData,
            contentType: "application/json; charset=utf-8",
            processData: false,
            success: function (response, textStatus, xhr) {
                alert("Thành công! Bạn đã cập nhật nhà xuất bản có ID = " + publisherId);
            },
            error: function (xhr, status, error) {
                var message = 'Có lỗi xảy ra:\n';
                alert(message + xhr.responseText);
                if (xhr.status === 400) {
                    // Clear previous errors
                    $('.is-invalid').removeClass('is-invalid');
                    $('.invalid-feedback').remove();

                    // Display validation errors
                    var errors = JSON.parse(xhr.responseText).error;
                    Object.keys(errors).forEach(function (key) {
                        var inputField = $('#' + key);
                        inputField.addClass('is-invalid');
                        inputField.after('<div class="invalid-feedback">' + errors[key] + '</div>').show();
                    });
                } else if (xhr.status === 404) {
                    window.location.href = '/admin/publishers';
                }
            }
        });
    }
});