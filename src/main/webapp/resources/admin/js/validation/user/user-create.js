$(document).ready(() => {

    //Save Time Out
    let typingTimer;
    const doneTypingInterval = 100;

    // Check First Name
    $('#firstName').on('input blur', () => {
        var firstName = $('#firstName').val().trim();
        var firstNameRegex = /^[\p{L}\p{M}]+(?: [\p{L}\p{M}]+)*$/u;

        clearTimeout(typingTimer);
        typingTimer = setTimeout(() => {
            if (firstName.length === 0) {
                $('#firstName').addClass('is-invalid');
                $('#firstName').siblings('.invalid-feedback').remove();
                $('#firstName').after('<div class="invalid-feedback">Bạn chưa nhập "Tên"</div>').show();
            } else if (firstName.length > 30) {
                $('#firstName').addClass('is-invalid');
                $('#firstName').siblings('.invalid-feedback').remove();
                $('#firstName').after('<div class="invalid-feedback">Độ dài không hợp lệ: "Tối đa 30 ký tự"</div>').show();
            } else if (!firstNameRegex.test(firstName)) {
                $('#firstName').addClass('is-invalid');
                $('#firstName').siblings('.invalid-feedback').remove();
                $('#firstName').after('<div class="invalid-feedback">Tên không hợp lệ: "Không chứa ký tự đặc biệt, chữ số"</div>').show();
            } else {
                $('#firstName').removeClass('is-invalid');
                $('#firstName').siblings('.invalid-feedback').remove();
            }
        }, doneTypingInterval);
    });

    // Check Last Name
    $('#lastName').on('input blur', () => {
        var lastName = $('#lastName').val().trim();
        var lastNameRegex = /^[\p{L}\p{M}]+(?: [\p{L}\p{M}]+)*$/u;

        clearTimeout(typingTimer);
        typingTimer = setTimeout(() => {
            if (lastName.length === 0) {
                $('#lastName').addClass('is-invalid');
                $('#lastName').siblings('.invalid-feedback').remove();
                $('#lastName').after('<div class="invalid-feedback">Bạn chưa nhập "Họ và Tên Đệm"</div>').show();
            } else if (lastName.length > 100) {
                $('#lastName').addClass('is-invalid');
                $('#lastName').siblings('.invalid-feedback').remove();
                $('#lastName').after('<div class="invalid-feedback">Độ dài không hợp lệ: "Tối đa 100 ký tự"</div>').show();
            } else if (!lastNameRegex.test(lastName)) {
                $('#lastName').addClass('is-invalid');
                $('#lastName').siblings('.invalid-feedback').remove();
                $('#lastName').after('<div class="invalid-feedback">Họ và Tên Đệm không hợp lệ: "Không chứa ký tự đặc biệt, chữ số"</div>').show();
            } else {
                $('#lastName').removeClass('is-invalid');
                $('#lastName').siblings('.invalid-feedback').remove();
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

    //Check Password
    $('#password').on('input blur', () => {
        var password = $('#password').val().trim();
        var confirmPassword = $('#confirmPassword').val();
        var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*\W).{8,}$/;

        if (confirmPassword !== password) {
            $('#confirmPassword').addClass('is-invalid');
            $('#confirmPassword').siblings('.invalid-feedback').remove();
            $('#confirmPassword').after('<div class="invalid-feedback">Mật khẩu không trùng khớp</div>').show();
        }
        else {
            $('#confirmPassword').removeClass('is-invalid');
            $('#confirmPassword').siblings('.invalid-feedback').remove();
        }

        if (password.length === 0) {
            $('#password').addClass('is-invalid');
            $('#password').siblings('.invalid-feedback').remove();
            $('#password').after('<div class="invalid-feedback">Bạn chưa nhập "Mật Khẩu"</div>').show();
        } else if (!passwordRegex.test(password)) {
            $('#password').addClass('is-invalid');
            $('#password').siblings('.invalid-feedback').remove();
            $('#password').after('<div class="invalid-feedback">"Mật Khẩu" phải chứa ít nhất 8 ký tự, bao gồm chữ thường, chữ hoa, số và ký tự đặc biệt</div>').show();
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
            $('#confirmPassword').after('<div class="invalid-feedback">Bạn chưa nhập "Xác Nhận Mật Khẩu"</div>').show();
        }
        else {
            if (confirmPassword !== password) {
                $('#confirmPassword').addClass('is-invalid');
                $('#confirmPassword').siblings('.invalid-feedback').remove();
                $('#confirmPassword').after('<div class="invalid-feedback">Mật khẩu không trùng khớp</div>').show();
            }
            else {
                $('#confirmPassword').removeClass('is-invalid');
                $('#confirmPassword').siblings('.invalid-feedback').remove();
            }
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

    // Check Date of Birth
    $('#dateOfBirth').on('input blur', () => {
        var dateOfBirth = $('#dateOfBirth').val();
        var today = new Date();
        var inputDate = new Date(dateOfBirth);

        if (!dateOfBirth) {
            $('#dateOfBirth').addClass('is-invalid');
            $('#dateOfBirth').siblings('.invalid-feedback').remove();
            $('#dateOfBirth').after('<div class="invalid-feedback">Bạn chưa nhập "Ngày Sinh"</div>').show();
        } else if (inputDate > today) {
            $('#dateOfBirth').addClass('is-invalid');
            $('#dateOfBirth').siblings('.invalid-feedback').remove();
            $('#dateOfBirth').after('<div class="invalid-feedback">"Ngày Sinh" không thể lớn hơn hoặc bằng ngày hiện tại</div>').show();
        } else {
            $('#dateOfBirth').removeClass('is-invalid');
            $('#dateOfBirth').siblings('.invalid-feedback').remove();
        }
    });

    //Check Role
    $('#selectRole').on('change', function () {
        var roleName = this.value;

        if (roleName === "") {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">Bạn chưa chọn "Vai Trò"</div>').show();
        } else {
            $(this).removeClass('is-invalid');
            $(this).siblings('.invalid-feedback').remove();
        }
    });
    //Check House Number
    $('#houseNumber').on('input blur', function () {
        const houseNumber = this.value;
        const houseNumberRegex = /^[\d\p{L}\s'/-]+$/u;

        if (houseNumber !== "") {
            if (!houseNumberRegex.test(houseNumber)) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Lỗi định dạng: "Số Nhà" không chứa ký tự đặc biệt</div>').show();
            } else {
                $(this).removeClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
            }
        }
    });

    //Check Street Name
    $('#street').on('input blur', function () {
        var street = this.value;
        var streetRegex = /^[\p{L}\p{M}\d\s,'-]+$/u;

        clearTimeout(typingTimer);
        typingTimer = setTimeout(() => {
            if (street.length === 0) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Bạn chưa nhập "Tên Đường"</div>').show();
            } else if (!streetRegex.test(street)) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">"Tên Đường" không hợp lệ</div>').show();
            } else {
                $(this).removeClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
            }
        }, doneTypingInterval);
    });

    //Check Ward Name
    $('#ward').on('input blur', function () {
        var ward = this.value;
        var wardRegex = /^[\p{L}\p{M}\d\s'-]+$/u;

        clearTimeout(typingTimer);
        typingTimer = setTimeout(() => {
            if (ward.length === 0) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Bạn chưa nhập "Tên Phường | Xã"</div>').show();
            } else if (!wardRegex.test(ward)) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">"Tên Phường | Xã" không hợp lệ</div>').show();
            } else {
                $(this).removeClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
            }
        }, doneTypingInterval);
    });

    //Check District Name
    $('#district').on('input blur', function () {
        var district = this.value;
        var districtRegex = /^[\p{L}\p{M}\d\s'-]+$/u;

        clearTimeout(typingTimer);
        typingTimer = setTimeout(() => {
            if (district.length === 0) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Bạn chưa nhập "Tên Quận | Huyện"</div>').show();
            } else if (!districtRegex.test(district)) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">"Tên Quận | Huyện" không hợp lệ</div>').show();
            } else {
                $(this).removeClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
            }
        }, doneTypingInterval);
    });

    //Check City Name
    $('#city').on('input blur', function () {
        var city = this.value;
        var cityRegex = /^[\p{L}\p{M}\s'-]+$/u;

        clearTimeout(typingTimer);
        typingTimer = setTimeout(() => {
            if (city.length === 0) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Bạn chưa nhập "Tên Tình | Thành Phố"</div>').show();
            } else if (!cityRegex.test(city)) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">"Tên Tỉnh | Thành phố" không hợp lệ</div>').show();
            } else {
                $(this).removeClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
            }
        }, doneTypingInterval);
    });

    //Form Submit
    $("#formCreateUser").submit(function (event) {
        event.preventDefault();
        var form = document.getElementById('formCreateUser');
        var formData = new FormData(form);
        var inValid = false;

        $("input[required], select[required], textarea[required]").each(function () {
            if ($(this).next('.invalid-feedback').length) {
                inValid = true;
            }
        });

        if (inValid) {
            alert('Có lỗi xảy ra: "BẠN CHƯA ĐIỀN ĐẦY ĐỦ THÔNG TIN HOẶC THÔNG TIN KHÔNG ĐÚNG ĐỊNH DẠNG !"');
            event.stopPropagation();

            $("input[required], select[required], textarea[required]").each(function () {
                if ($(this).next('.invalid-feedback').length) {
                    $(this).addClass('is-invalid');
                    $(this).siblings('.invalid-feedback').show();
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
            url: 'http://localhost:8082/api/admin/users',
            data: formData,
            contentType: false,
            processData: false,
            success: function (response) {
                alert('Bạn đã thêm mới người dùng thành công!');
                window.location.href = '/admin/users';
            },
            error: function (xhr, status, error) {
                if (xhr.status === 400) {
                    alert('Lỗi phía Server: Thông tin không hợp lệ hoặc đã tồn tại trước đó');
                    // Clear previous errors
                    $('.is-invalid').removeClass('is-invalid');
                    $('.invalid-feedback').removeAll();

                    // Display validation errors
                    var errors = JSON.parse(xhr.responseText);
                    Object.keys(errors).forEach(function (key) {
                        var inputField = $('#' + key);
                        inputField.addClass('is-invalid');
                        inputField.after('<div class="invalid-feedback">' + errors[key] + '</div>').show();
                    });
                } else {
                    alert('Lỗi khi tạo người dùng: ' + xhr.responseText);
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