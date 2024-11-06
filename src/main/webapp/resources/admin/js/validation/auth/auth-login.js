$(document).ready(() => {

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

    //Check Password
    $('#password').on('input blur', () => {
        var password = $('#password').val().trim();

        if (password.length === 0) {
            $('#password').addClass('is-invalid');
            $('#password').siblings('.invalid-feedback').remove();
            $('#hide-password').after('<div class="invalid-feedback">Bạn chưa nhập "Mật Khẩu"</div>').show();
        } else {
            $('#password').removeClass('is-invalid');
            $('#password').siblings('.invalid-feedback').remove();
        }
    });

    $('#formAuthentication').submit(function (event) {
        event.preventDefault();
        var formData = new FormData();
        var inValid = false;

        formData.append("email", $('#email').val());
        formData.append("password", $('#password').val());

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
        }
    });
});