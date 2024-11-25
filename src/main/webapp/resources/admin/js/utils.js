$(document).ready(() => {
    var authorsActive = $('#authorsActive').data('authors-active');
    var booksActive = $('#booksActive').data('books-active');
    var categoriesActive = $('#categoriesActive').data('categories-active');
    var ordersActive = $('#ordersActive').data('orders-active');
    var publishersActive = $('#publishersActive').data('publishers-active');
    var rolesActive = $('#rolesActive').data('roles-active');
    var usersActive = $('#usersActive').data('users-active');

    if (booksActive) {
        $('.menu-item').removeClass('active');
        $('.books').addClass('active');
    } else if (authorsActive) {
        $('.menu-item').removeClass('active');
        $('.authors').addClass('active');
    } else if (categoriesActive) {
        $('.menu-item').removeClass('active');
        $('.categories').addClass('active');
    } else if (ordersActive) {
        $('.menu-item').removeClass('active');
        $('.orders').addClass('active');
    } else if (publishersActive) {
        $('.menu-item').removeClass('active');
        $('.publishers').addClass('active');
    } else if (rolesActive) {
        $('.menu-item').removeClass('active');
        $('.roles').addClass('active');
    } else if (usersActive) {
        $('.menu-item').removeClass('active');
        $('.users').addClass('active');
    } else {
        $('.menu-item').removeClass('active');
        $('.admin-db').addClass('active');
    }
});