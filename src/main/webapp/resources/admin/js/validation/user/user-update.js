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

    //Check Username
    $('#username').on('input blur', function () {
        const username = this.value;
        const usernameRegex = /^(?![0-9])[\w-]+$/;

        if (username.length === 0) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">"Tên Tài Khoản" không được để trống</div>').show();
        } else if (!usernameRegex.test(username)) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">Lỗi định dạng: "Tên Tài Khoản" không chứa ký tự đặc biệt, tiếng việt và khoảng trắng</div>').show();
        } else if (username.length > 20 || username < 3) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">"Tên Tài Khoản" quá ngắn hoặc quá dài: Tối thiểu 3 và tối đa 20 ký tự</div>').show();
        } else {
            $(this).removeClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
        }
    });

    //Check Address
    $('#address').on('input blur', function () {
        const address = this.value;
        const addressRegex = /^[\p{L}\p{N}.,\s/-]+,\s*[\p{L}\p{N}.\s-]+,\s*[\p{L}\p{N}.\s-]+,\s*[\p{L}\p{N}.\s-]+$/u;

        clearTimeout(typingTimer);
        typingTimer = setTimeout(() => {
            if (address.length === 0) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">"Địa Chỉ" không được để trống</div>').show();
            } else if (!addressRegex.test(address)) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Lỗi định dạng: "Địa Chỉ" phải bao gồm: số nhà tên đường, tên phường, tên quận, tên thành phố</div>').show();
            } else {
                $(this).removeClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
            }
        }, doneTypingInterval);
    });

    //Check Date Of Birth
    $('#dateOfBirth').on('input blur', function () {
        const today = new Date();
        const dateOfBirth = new Date(this.value);

        if (!this.value) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">"Ngày Sinh" không được để trống</div>').show();
        } else if (dateOfBirth > today) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">"Ngày Sinh" không được lớn hơn ngày hiện tại</div>').show();
        } else {
            $(this).removeClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
        }
    });

    //Form Submit
    $('#formUpdateUser').submit(function (event) {
        event.preventDefault();
        var form = document.getElementById('formUpdateUser');
        var formData = new FormData(form);
        var userId = $('#userId').val();
        var inValid = false;

        $('.validate').each(function () {
            if ($(this).next('.invalid-feedback').length) {
                inValid = true;
            }
        });

        if (inValid) {
            alert('Có lỗi xảy ra: "BẠN CHƯA ĐIỀN ĐẦY ĐỦ THÔNG TIN HOẶC THÔNG TIN KHÔNG ĐÚNG ĐỊNH DẠNG !"');
            event.stopPropagation();

            $(".validate").each(function () {
                if ($(this).next('.invalid-feedback').length) {
                    $(this).addClass('is-invalid');
                    $(this).siblings('.invalid-feedback').show();
                }
            });
        } else {
            sendAjaxRequest(userId, formData);
        }
    });

    // Call API using FormData
    function sendAjaxRequest(userId, formData) {
        $.ajax({
            type: 'PUT',
            url: 'http://localhost:8082/api/admin/users/' + userId,
            data: formData,
            contentType: false,
            processData: false,
            success: function (response) {
                alert('Bạn đã cập nhật người dùng thành công!');
            },
            error: function (xhr, status, error) {
                if (xhr.status === 400) {
                    alert('Lỗi phía Server: Thông tin không hợp lệ hoặc đã tồn tại trước đó');
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
                    alert('Lỗi cập nhật người dùng: Thông tin Người dùng không tồn tại hoặc đã bị xóa trước đó !' + xhr.responseText);
                    window.location.href = '/admin/users';
                } else {
                    alert('Lỗi khi cập nhật người dùng: ' + xhr.responseText);
                }
            }
        });
    }

    // Preview Avatar
    const avatarFile = $("#avatarFile");
    avatarFile.change(
        function (e) {
            const imfURL = URL.createObjectURL(e.target.files[0]);
            $("#avatarPreview").attr("src", imfURL);
            $("#avatarPreview").css({ "display": "block" });
        }
    );
});