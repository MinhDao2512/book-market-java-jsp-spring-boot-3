$(document).ready(() => {

    //Add invalid-feedback for all input
    $("input[required], select[required], textarea[required]").each(function () {
        // check exists div.invalid-feedback 
        if (!$(this).next('.invalid-feedback').length) {
            $(this).after('<div class="invalid-feedback">Bạn chưa nhập thông tin này !</div>');
        }
    });
});