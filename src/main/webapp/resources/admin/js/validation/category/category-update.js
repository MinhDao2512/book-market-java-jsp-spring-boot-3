$(document).ready(() => {
    //Save Time Out
    let typingTimer;
    const doneTypingInterval = 100;

    //Check Name
    $('#name').on('input blur', function () {
        const name = this.value;
        const nameRegex = /^[\p{L}\s,-]+$/u;

        clearTimeout(typingTimer);
        typingTimer = setTimeout(() => {
            if (name.length === 0) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Bạn chưa nhập "Tên" thể lọai</div>').show();
            } else if (name.length > 50) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">"Tên" của thể loại quá dài: Tối đa 50 ký tự</div>').show();
            } else if (!nameRegex.test(name)) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Lỗi định dạng: "Tên" thể loại không chứa ký tự đặc biệt, chữ số</div>').show();
            } else {
                $(this).removeClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
            }
        }, doneTypingInterval);
    });

    //Check Description
    $('#description').on('input blur', function () {
        const description = this.value;
        const descriptionRegex = /^[\p{L}\s,-]+$/u;

        clearTimeout(typingTimer);
        typingTimer = setTimeout(() => {
            if (description.length === 0) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Bạn chưa nhập "Mô Tả" thể lọai</div>').show();
            } else if (description.length > 100) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">"Mô Tả" của thể loại quá dài: Tối đa 100 ký tự</div>').show();
            } else if (!descriptionRegex.test(description)) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Lỗi định dạng: "Mô Tả" thể loại không chứa ký tự đặc biệt và chữ số</div>').show();
            } else {
                $(this).removeClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
            }
        }, doneTypingInterval);
    });

    //Form Submit
    $("#formUpdateCategory").submit(function (event) {
        event.preventDefault();
        var form = document.getElementById('formUpdateCategory');
        var formData = new FormData(form);
        var categoryId = $('#categoryId').val();
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
            sendAjaxRequest(formData, categoryId);
        }
    });

    // Call API using FormData
    function sendAjaxRequest(formData, categoryId) {
        $.ajax({
            type: 'PUT',
            url: 'http://localhost:8082/api/admin/categories/' + categoryId,
            data: formData,
            contentType: false,
            processData: false,
            success: function (response, textStatus, xhr) {
                alert("Thành công! Bạn đã cập nhật thể loại có id = " + categoryId);
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
                    alert('Thất bại! Thông tin thể loai này không tồn tại.');
                    window.location.href = '/admin/categories';
                } else {
                    alert('Lỗi khi tạo mới thể loại: ' + xhr.responseText);
                }
            }
        });
    }
});