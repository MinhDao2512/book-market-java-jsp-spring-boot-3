$(document).ready(() => {

    // Check First Name
    $('#firstName').on('input blur', () => {
        var firstName = $('#firstName').val().trim();
        var firstNameRegex = /^[a-zA-Z\s]+$/;

        if (firstName.length === 0) {
            $('#firstName').addClass('is-invalid');
            $('#firstName').siblings('.invalid-feedback').text('Bạn chưa nhập "Tên"!').show();
        } else if (firstName.length > 30) {
            $('#firstName').addClass('is-invalid');
            $('#firstName').siblings('.invalid-feedback').text('Độ dài chuỗi không hợp lệ: "Tối đa 30 ký tự."').show();
        } else if (!firstNameRegex.test(firstName)) {
            $('#firstName').addClass('is-invalid');
            $('#firstName').siblings('.invalid-feedback').text('Tên không hợp lệ: "Không chứa ký tự đặc biệt, chữ số và tiếng việt."').show();
        } else {
            $('#firstName').removeClass('is-invalid');
            $('#firstName').siblings('.invalid-feedback').hide();
        }
    });

    // Check Last Name
    $('#lastName').on('input blur', () => {
        var lastName = $('#lastName').val().trim();
        var lastNameRegex = /^[a-zA-Z\s]*$/;

        if (lastName.length === 0) {
            $('#lastName').addClass('is-invalid');
            $('#lastName').siblings('.invalid-feedback').text('Bạn chưa nhập "Họ và Tên đệm"!').show();
        } else if (lastName.length > 100) {
            $('#lastName').addClass('is-invalid');
            $('#lastName').siblings('.invalid-feedback').text('Độ dài chuỗi không hợp lệ: "Tối đa 100 ký tự".').show();
        } else if (!lastNameRegex.test(lastName)) {
            $('#lastName').addClass('is-invalid');
            $('#lastName').siblings('.invalid-feedback').text('Chuỗi không hợp lệ: "Không chứa ký tự đặc biệt, chữ số và tiếng việt."').show();
        } else {
            $('#lastName').removeClass('is-invalid');
            $('#lastName').siblings('.invalid-feedback').hide();
        }
    });

    //Check Email
    $('#email').on('input blur', () => {
        var email = $('#email').val().trim();
        var emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

        if (email.length === 0) {
            $('#email').addClass('is-invalid');
            $('#email').siblings('.invalid-feedback').text('Bạn chưa nhập địa chỉ "Email"!').show();
        } else if (!emailRegex.test(email)) {
            $('#email').addClass('is-invalid');
            $('#email').siblings('.invalid-feedback').text('Địa chỉ "Email" không hợp lệ.').show();
        } else {
            $('#email').removeClass('is-invalid');
            $('#email').siblings('.invalid-feedback').hide();
        }
    });

    //Check Password
    $('#password').on('input blur', () => {
        var password = $('#password').val().trim();
        var confirmPassword = $('#confirmPassword').val();
        var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*\W).{8,}$/;

        if (confirmPassword !== password) {
            $('#confirmPassword').addClass('is-invalid');
            $('#confirmPassword').siblings('.invalid-feedback').text('Mật khẩu không trùng khớp!').show();
        }
        else {
            $('#confirmPassword').removeClass('is-invalid');
            $('#confirmPassword').siblings('.invalid-feedback').hide();
        }

        if (password.length === 0) {
            $('#password').addClass('is-invalid');
            $('#password').siblings('.invalid-feedback').text('Bạn chưa nhập "Mật Khẩu"!').show();
        } else if (!passwordRegex.test(password)) {
            $('#password').addClass('is-invalid');
            $('#password').siblings('.invalid-feedback').text('"Mật Khẩu" phải chứa ít nhất 8 ký tự, bao gồm chữ thường, chữ hoa, số và ký tự đặc biệt!').show();
        } else {
            $('#password').removeClass('is-invalid');
            $('#password').siblings('.invalid-feedback').hide();
        }
    });

    //Check confirm Password
    $('#confirmPassword').on('input blur', () => {
        var password = $('#password').val();
        var confirmPassword = $('#confirmPassword').val();

        if (confirmPassword.length === 0) {
            $('#confirmPassword').addClass('is-invalid');
            $('#confirmPassword').siblings('.invalid-feedback').text('Bạn chưa nhập lại "Mật Khẩu"!').show();
        }
        else {
            if (confirmPassword !== password) {
                $('#confirmPassword').addClass('is-invalid');
                $('#confirmPassword').siblings('.invalid-feedback').text('Mật khẩu không trùng khớp!').show();
            }
            else {
                $('#confirmPassword').removeClass('is-invalid');
                $('#confirmPassword').siblings('.invalid-feedback').hide();
            }
        }
    });

    // Check Phone Number
    $('#phoneNumber').on('input blur', () => {
        var phoneNumber = $('#phoneNumber').val().trim();
        var phoneRegex = /^(\+84|0)(\s?\d{3})(\s?\d{3})(\s?\d{3})$/;

        if (phoneNumber.length === 0) {
            $('#phoneNumber').addClass('is-invalid');
            $('#phoneNumber').siblings('.invalid-feedback').text('Bạn chưa nhập "Số Điện Thoại"!').show();
        } else if (!phoneRegex.test(phoneNumber)) {
            $('#phoneNumber').addClass('is-invalid');
            $('#phoneNumber').siblings('.invalid-feedback').text('"Số Điện Thoại" không hợp lệ!').show();
        } else {
            $('#phoneNumber').removeClass('is-invalid');
            $('#phoneNumber').siblings('.invalid-feedback').hide();
        }
    });

    // Check Date of Birth
    $('#dateOfBirth').on('input blur', () => {
        var dateOfBirth = $('#dateOfBirth').val();
        var today = new Date();
        var inputDate = new Date(dateOfBirth);

        if (!dateOfBirth) {
            $('#dateOfBirth').addClass('is-invalid');
            $('#dateOfBirth').siblings('.invalid-feedback').text('Bạn chưa nhập "Ngày Sinh"!').show();
        } else if (inputDate > today) {
            $('#dateOfBirth').addClass('is-invalid');
            $('#dateOfBirth').siblings('.invalid-feedback').text('"Ngày Sinh" không thể lớn hơn hoặc bằng ngày hiện tại!').show();
        } else {
            $('#dateOfBirth').removeClass('is-invalid');
            $('#dateOfBirth').siblings('.invalid-feedback').hide();
        }
    });

    //Check Role
    $('#selectRole').on('change', function () {
        var roleName = this.value;

        if (roleName === "") {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').text('Bạn chưa chọn "Vai Trò"!').show();
        } else {
            $(this).removeClass('is-invalid');
            $(this).siblings('.invalid-feedback').hide();
        }
    });

    //Check Street Name
    $('#street').on('input blur', function () {
        var street = this.value;
        var streetRegex = /^[a-zA-Z\s\-\.]+$/;

        if (street.length === 0) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').text('Bạn chưa nhập "Tên Đường"!').show();
        } else if (!streetRegex.test(street)) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').text('"Tên Đường" không hợp lệ!').show();
        } else {
            $(this).removeClass('is-invalid');
            $(this).siblings('.invalid-feedback').hide();
        }
    });

    //Check Ward Name
    $('#ward').on('input blur', function () {
        var ward = this.value;
        var wardRegex = /^[a-zA-Z\s\-\,\.]+$/;

        if (ward.length === 0) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').text('Bạn chưa nhập "Tên Phường | Xã"!').show();
        } else if (!wardRegex.test(ward)) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').text('"Tên Phường | Xã" không hợp lệ!').show();
        } else {
            $(this).removeClass('is-invalid');
            $(this).siblings('.invalid-feedback').hide();
        }
    });

    //Check District Name
    $('#district').on('input blur', function () {
        var district = this.value;
        var districtRegex = /^[a-zA-Z0-9\s\-\,\.]+$/;

        if (district.length === 0) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').text('Bạn chưa nhập "Tên Quận | Huyện"!').show();
        } else if (!districtRegex.test(district)) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').text('"Tên Quận | Huyện" không hợp lệ!').show();
        } else {
            $(this).removeClass('is-invalid');
            $(this).siblings('.invalid-feedback').hide();
        }
    });

    //Check City Name
    $('#city').on('input blur', function () {
        var city = this.value;
        var cityRegex = /^[a-zA-Z\s\-\,\.]+$/;

        if (city.length === 0) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').text('Bạn chưa nhập "Tên Tình | Thành phố"!').show();
        } else if (!cityRegex.test(city)) {
            $(this).addClass('is-invalid');
            $(this).siblings('.invalid-feedback').text('"Tên Tỉnh | Thành phố" không hợp lệ!').show();
        } else {
            $(this).removeClass('is-invalid');
            $(this).siblings('.invalid-feedback').hide();
        }
    });

    //Form Submit
    $("#formCreateUser").submit(function (event) {
        event.preventDefault();
        var form = document.getElementById('formCreateUser');
        var formData = new FormData(form);

        if (!form.checkValidity()) {
            alert('Có lỗi xảy ra: "BẠN CHƯA ĐIỀN ĐẦY ĐỦ THÔNG TIN!"');
            event.stopPropagation()
            form.classList.add('was-validated');
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
                    // Clear previous errors
                    $('.is-invalid').removeClass('is-invalid');
                    $('.invalid-feedback').hide();

                    // Display validation errors
                    var errors = JSON.parse(xhr.responseText);
                    Object.keys(errors).forEach(function (key) {
                        var inputField = $('#' + key);
                        inputField.addClass('is-invalid');
                        inputField.siblings('.invalid-feedback').text(errors[key]).show();
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