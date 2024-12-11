$(document).ready(() => {

    //Save Time Out
    let typingTimer;
    const doneTypingInterval = 100;

    //Check Empty Data
    $('.required').each(function () {
        if (!$(this).val() && !$(this).is('.paypal')) {
            $(this).siblings('.invalid-feedback').remove();
            $(this).after('<div class="invalid-feedback">Bạn chưa điền thông tin này!</div>');
        }
    });

    //Check Receiver Name
    $('#receiverName').on('input blur', function () {
        const receiverName = this.value;
        const receiverNameRegex = /^\p{L}+(?:[\s-]\p{L}+)*$/u;

        clearTimeout(typingTimer);
        typingTimer = setTimeout(() => {
            if (receiverName.length === 0) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Bạn chưa điền thông tin này!</div>').show();
            } else if (!receiverNameRegex.test(receiverName)) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Lỗi định dạng: Chứa số, ký tự đặc biệt hoặc thừa khoảng trắng !</div>').show();
            } else if (receiverName.length > 100) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">"Tên" quá dài: Tối đa 100 ký tự</div>').show();
            } else {
                $(this).removeClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
            }
        }, doneTypingInterval);
    });

    //Check Shipping Address
    $('#shippingAddress').on('input blur', function () {
        const shippingAddress = this.value;
        const shippingAddressRegex = /^[\p{L}\d\s.,-/#()]+$/u;

        clearTimeout(typingTimer);
        typingTimer = setTimeout(() => {
            if (shippingAddress.length === 0) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Bạn chưa điền thông tin này</div>').show();
            } else if (!shippingAddressRegex.test(shippingAddress)) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Lỗi định dạng: "Địa Chỉ" không chứa các ký tự đặc biệt</div>').show();
            } else if (shippingAddress.length > 500) {
                $(this).addClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
                $(this).after('<div class="invalid-feedback">Địa chỉ quá dài: "Địa Chỉ" chỉ tối đa 500 ký tự</div>').show();
            } else {
                $(this).removeClass('is-invalid');
                $(this).siblings('.invalid-feedback').remove();
            }
        }, doneTypingInterval);
    });

    // Check Phone Number
    $('#receiverPhone').on('input blur', () => {
        var phoneNumber = $('#receiverPhone').val().trim();
        var phoneRegex = /^(\+84|0)(\s?\d{3})(\s?\d{3})(\s?\d{3})$/;

        if (phoneNumber.length === 0) {
            $('#receiverPhone').addClass('is-invalid');
            $('#receiverPhone').siblings('.invalid-feedback').remove();
            $('#receiverPhone').after('<div class="invalid-feedback">Bạn chưa nhập "Số Điện Thoại"</div>').show();
        } else if (!phoneRegex.test(phoneNumber)) {
            $('#receiverPhone').addClass('is-invalid');
            $('#receiverPhone').siblings('.invalid-feedback').remove();
            $('#receiverPhone').after('<div class="invalid-feedback">"Số Điện Thoại" không hợp lệ</div>').show();
        } else {
            $('#receiverPhone').removeClass('is-invalid');
            $('#receiverPhone').siblings('.invalid-feedback').remove();
        }
    });

    //Check Email
    $('#receiverEmail').on('input blur', () => {
        var email = $('#receiverEmail').val().trim();
        var emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

        if (email.length === 0) {
            $('#receiverEmail').addClass('is-invalid');
            $('#receiverEmail').siblings('.invalid-feedback').remove();
            $('#receiverEmail').after('<div class="invalid-feedback">Bạn chưa nhập địa chỉ "Email"</div>').show();
        } else if (!emailRegex.test(email)) {
            $('#receiverEmail').addClass('is-invalid');
            $('#receiverEmail').siblings('.invalid-feedback').remove();
            $('#receiverEmail').after('<div class="invalid-feedback">Địa chỉ "Email" không hợp lệ</div>').show();
        } else {
            $('#receiverEmail').removeClass('is-invalid');
            $('#receiverEmail').siblings('.invalid-feedback').remove();
        }
    });

    //Check select paymentMethod
    $('input[type="checkbox"]').on('change', function () {
        $('input[name="paymentMethod"]').not(this).prop('checked', false);

        $cod = $('#payment');
        $banking = $('#paypal');

        if (!$cod.is(':checked') && !$banking.is(':checked')) {
            $('.paypal').addClass('is-invalid');
            $('.paypal').siblings('.invalid-feedback').remove();
            $('.paypal').after('<div class="invalid-feedback">Bạn chưa chọn phương thức thành toán.</div>').show();
        } else {
            $('.paypal').removeClass('is-invalid');
            $('.paypal').siblings('.invalid-feedback').remove();
        }
    });

    //Form Submit
    $("#checkoutForm").submit(function (event) {
        event.preventDefault();
        //create FormData
        var formData = new FormData(document.getElementById('checkoutForm'));
        //mapping formData to array
        var object = {};
        object['totalPrice'] = $('#totalPrice').text().replace(/[^\d.-]/g, '');
        object['quantity'] = $('.quantity').data('quantity');

        formData.forEach((value, key) => object[key] = value);
        //check valid data 
        var inValid = false;

        $(".required").each(function () {
            // check exists div.invalid-feedback 
            if ($(this).next('.invalid-feedback').length) {
                inValid = true;
            }
        });

        if (inValid) {
            $.toast({
                heading: 'Lỗi thông tin !',
                text: 'Bạn chưa điền thông tin hoặc điền sai định dạng.',
                position: 'top-right',
                icon: 'error'
            })
            event.stopPropagation()
            $(".required").each(function () {
                if ($(this).next('.invalid-feedback').length) {
                    $(this).addClass('is-invalid');
                    $(this).next('.invalid-feedback').show();
                }
            });
        } else {
            sendAjaxRequest(JSON.stringify(object));

        }
    });

    // Call API using FormData
    function sendAjaxRequest(formData) {
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8082/api/checkout',
            data: formData,
            contentType: "application/json; charset=utf-8",
            processData: false,
            success: function (response, textStatus, xhr) {
                var dataResponse = JSON.parse(xhr.responseText).data;
                if (dataResponse['paymentMethod'] === 'BANKING') {
                    window.location.href = dataResponse['vnpUrl'];
                } else {
                    window.location.href = "/thanks";
                }
            },
            error: function (xhr, status, error) {
                $.toast({
                    heading: 'Đặt hàng:',
                    text: 'Không thể tiến hành đặt hàng.',
                    position: 'top-right',
                    icon: 'error'
                })
            }
        });
    }
});