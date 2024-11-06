$(document).ready(() => {

    //Save Time Out
    let typingTimer;
    const doneTypingInterval = 100;

    //Check Full Name
    $('#fullName').on('input blur', function () {
        const fullName = this.value;
        const fullNameRegex = /^[\p{L}\p{M}\s'-]+$/u;

        clearTimeout(typingTimer);
        typingTimer = setTimeout(() => {
            if (fullName.length === 0) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">"Họ và Tên" không được để trống</div>').show();
            } else if (!fullNameRegex.test(fullName)) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Lỗi định dạng: "Họ và Tên" không chứa ký tự đặc biệt và chữ số</div>').show();
            } else if (fullName.length > 100) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">"Họ và Tên" quá dài: Tối đa 100 ký tự</div>').show();
            } else {
                $(this).removeClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
            }
        }, doneTypingInterval);
    });

    //Check Email
    $('#email').on('input blur', () => {
        var email = $('#email').val().trim();
        var emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

        if (email.length === 0) {
            $('#email').addClass('is-invalid');
            $('#email').siblings('.invalid-feedback').remove();
            $('#email').after('<div class="invalid-feedback">Bạn chưa nhập địa chỉ "Email"</div>').show();
        } else if (!emailRegex.test(email)) {
            $('#email').addClass('is-invalid');
            $('#email').siblings('.invalid-feedback').remove();
            $('#email').after('<div class="invalid-feedback">Địa chỉ "Email" không hợp lệ</div>').show();
        } else {
            $('#email').removeClass('is-invalid');
            $('#email').siblings('.invalid-feedback').remove();
        }
    });

    // Check Phone Number
    $('#phoneNumber').on('input blur', () => {
        var phoneNumber = $('#phoneNumber').val().trim();
        var phoneRegex = /^(\+84|0)(\s?\d{3})(\s?\d{3})(\s?\d{3})$/;

        if (phoneNumber.length === 0) {
            $('#phoneNumber').addClass('is-invalid');
            $('#phoneNumber').siblings('.invalid-feedback').remove();
            $('#phoneNumber').after('<div class="invalid-feedback">Bạn chưa nhập "Số Điện Thoại"</div>').show();
        } else if (!phoneRegex.test(phoneNumber)) {
            $('#phoneNumber').addClass('is-invalid');
            $('#phoneNumber').siblings('.invalid-feedback').remove();
            $('#phoneNumber').after('<div class="invalid-feedback">"Số Điện Thoại" không hợp lệ</div>').show();
        } else {
            $('#phoneNumber').removeClass('is-invalid');
            $('#phoneNumber').siblings('.invalid-feedback').remove();
        }
    });

    //Check Password
    $('#password').on('input blur', () => {
        var password = $('#password').val().trim();
        var confirmPassword = $('#confirmPassword').val();
        var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*\W).{8,}$/;

        if (confirmPassword !== password) {
            $('#confirmPassword').addClass('is-invalid');
            $('#confirmPassword').siblings('.invalid-feedback').remove();
            $('#hide-confirmPassword').after('<div class="invalid-feedback">Mật khẩu không trùng khớp</div>').show();
        }
        else {
            $('#confirmPassword').removeClass('is-invalid');
            $('#confirmPassword').siblings('.invalid-feedback').remove();
        }

        if (password.length === 0) {
            $('#password').addClass('is-invalid');
            $('#password').siblings('.invalid-feedback').remove();
            $('#hide-password').after('<div class="invalid-feedback">Bạn chưa nhập "Mật Khẩu"</div>').show();
        } else if (!passwordRegex.test(password)) {
            $('#password').addClass('is-invalid');
            $('#password').siblings('.invalid-feedback').remove();
            $('#hide-password').after('<div class="invalid-feedback">"Mật Khẩu" phải chứa ít nhất 8 ký tự, bao gồm chữ thường, chữ hoa, số và ký tự đặc biệt</div>').show();
        } else {
            $('#password').removeClass('is-invalid');
            $('#password').siblings('.invalid-feedback').remove();
        }
    });

    //Check confirm Password
    $('#confirmPassword').on('input blur', () => {
        var password = $('#password').val();
        var confirmPassword = $('#confirmPassword').val();

        if (confirmPassword.length === 0) {
            $('#confirmPassword').addClass('is-invalid');
            $('#confirmPassword').siblings('.invalid-feedback').remove();
            $('#hide-confirmPassword').after('<div class="invalid-feedback">Bạn chưa nhập "Xác Nhận Mật Khẩu"</div>').show();
        }
        else {
            if (confirmPassword !== password) {
                $('#confirmPassword').addClass('is-invalid');
                $('#confirmPassword').siblings('.invalid-feedback').remove();
                $('#hide-confirmPassword').after('<div class="invalid-feedback">Mật khẩu không trùng khớp</div>').show();
            }
            else {
                $('#confirmPassword').removeClass('is-invalid');
                $('#hide-confirmPassword').siblings('.invalid-feedback').remove();
            }
        }
    });

    //Check Confirm Service
    $('#confirmService').on('change', function () {
        if ($(this).is(':checked')) {
            $(this).removeClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
        } else {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $('#checkLabel').after('<div class="invalid-feedback">Bạn chưa đồng ý với "Điều khoản và Dịch vụ"</div>').show();
        }
    });

    $('#formAuthentication').submit(function (event) {
        event.preventDefault();
        var formData = new FormData();
        var inValid = false;

        formData.append("email", $('#email').val());
        formData.append("password", $('#password').val());
        formData.append("phoneNumber", $('#phoneNumber').val());
        formData.append("fullName", $('#fullName').val());

        $('.validate').each(function () {
            if ($(this).nextAll('.invalid-feedback').length) {
                inValid = true;
            }
        });

        if (inValid) {
            $(".validate").each(function () {
                if ($(this).nextAll('.invalid-feedback').length) {
                    $(this).addClass('is-invalid');
                    $(this).nextAll('.invalid-feedback').show();
                }
            });
        } else {
            sendAjaxRequest(formData);
        }

        function sendAjaxRequest(formData) {
            $.ajax({
                type: 'POST',
                url: 'http://localhost:8082/api/register',
                data: formData,
                contentType: false,
                processData: false,
                success: function (response, textStatus, xhr) {
                    alert("BẠN ĐÃ TẠO TÀI KHOẢN THÀNH CÔNG. CHUYỂN ĐẾN TRANG ĐĂNG NHẬP!");
                    window.location.href = '/login';
                },
                error: function (xhr, status, error) {
                    if (xhr.status == 400) {
                        alert('LỖI PHÍA SERVER: THÔNG TIN KHÔNG HỢP LỆ HOẶC ĐÃ TỒN TẠI TRƯỚC ĐÓ!');
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
                        alert('LỖI KHI ĐĂNG KÝ TÀI KHOẢN: ' + xhr.responseText);
                    }
                }
            });
        }
    });
});