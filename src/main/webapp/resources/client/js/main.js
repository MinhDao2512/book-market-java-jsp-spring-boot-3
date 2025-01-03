/*  ---------------------------------------------------
    Template Name: Ogani
    Description:  Ogani eCommerce  HTML Template
    Author: Colorlib
    Author URI: https://colorlib.com
    Version: 1.0
    Created: Colorlib
---------------------------------------------------------  */

'use strict';

(function ($) {

    /*------------------
        Preloader
    --------------------*/
    $(window).on('load', function () {
        $(".loader").fadeOut();
        $("#preloder").delay(200).fadeOut("slow");

        /*------------------
            Gallery filter
        --------------------*/
        $('.featured__controls li').on('click', function () {
            $('.featured__controls li').removeClass('active');
            $(this).addClass('active');
        });
        if ($('.featured__filter').length > 0) {
            var containerEl = document.querySelector('.featured__filter');
            var mixer = mixitup(containerEl);
        }
    });

    /*------------------
        Background Set
    --------------------*/
    $('.set-bg').each(function () {
        var bg = $(this).data('setbg');
        $(this).css('background-image', 'url(' + bg + ')');
    });

    //Humberger Menu
    $(".humberger__open").on('click', function () {
        $(".humberger__menu__wrapper").addClass("show__humberger__menu__wrapper");
        $(".humberger__menu__overlay").addClass("active");
        $("body").addClass("over_hid");
    });

    $(".humberger__menu__overlay").on('click', function () {
        $(".humberger__menu__wrapper").removeClass("show__humberger__menu__wrapper");
        $(".humberger__menu__overlay").removeClass("active");
        $("body").removeClass("over_hid");
    });

    /*------------------
        Navigation
    --------------------*/
    $(".mobile-menu").slicknav({
        prependTo: '#mobile-menu-wrap',
        allowParentLinks: true
    });

    /*------------------
    Dynamic Menu Active
    --------------------*/
    var currentPath = window.location.pathname;
    $('.header__menu ul li').each(function () {
        var linkPath = $(this).find('a').attr('href'); // Lấy giá trị href của thẻ <a>
        if (currentPath === linkPath) {
            $(this).addClass('active'); // Thêm active cho mục phù hợp
        }
    });

    /*-----------------------
        Categories Slider
    ------------------------*/
    $(".categories__slider").owlCarousel({
        loop: true,
        margin: 0,
        items: 4,
        dots: false,
        nav: true,
        navText: ["<span class='fa fa-angle-left'><span/>", "<span class='fa fa-angle-right'><span/>"],
        animateOut: 'fadeOut',
        animateIn: 'fadeIn',
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true,
        responsive: {

            0: {
                items: 1,
            },

            480: {
                items: 2,
            },

            768: {
                items: 3,
            },

            992: {
                items: 4,
            }
        }
    });


    $('.hero__categories__all').on('click', function () {
        $('.hero__categories ul').slideToggle(400);
    });

    /*--------------------------
        Latest Product Slider
    ----------------------------*/
    $(".latest-product__slider").owlCarousel({
        loop: true,
        margin: 0,
        items: 1,
        dots: false,
        nav: true,
        navText: ["<span class='fa fa-angle-left'><span/>", "<span class='fa fa-angle-right'><span/>"],
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true
    });

    /*-----------------------------
        Product Discount Slider
    -------------------------------*/
    $(".product__discount__slider").owlCarousel({
        loop: true,
        margin: 0,
        items: 3,
        dots: true,
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true,
        responsive: {

            320: {
                items: 1,
            },

            480: {
                items: 2,
            },

            768: {
                items: 2,
            },

            992: {
                items: 3,
            }
        }
    });

    /*---------------------------------
        Product Details Pic Slider
    ----------------------------------*/
    $(".product__details__pic__slider").owlCarousel({
        loop: true,
        margin: 20,
        items: 4,
        dots: true,
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true
    });

    /*-----------------------
        Price Range Slider
    ------------------------ */
    var rangeSlider = $(".price-range"),
        minamount = $("#minamount"),
        maxamount = $("#maxamount"),
        minPrice = rangeSlider.data('min'),
        maxPrice = rangeSlider.data('max');
    rangeSlider.slider({
        range: true,
        min: minPrice,
        max: maxPrice,
        values: [minPrice, maxPrice],
        slide: function (event, ui) {
            minamount.val('$' + ui.values[0]);
            maxamount.val('$' + ui.values[1]);
        }
    });
    minamount.val('$' + rangeSlider.slider("values", 0));
    maxamount.val('$' + rangeSlider.slider("values", 1));

    /*--------------------------
        Select
    ----------------------------*/
    $("select").niceSelect();

    /*------------------
        Single Product
    --------------------*/
    $('.product__details__pic__slider img').on('click', function () {

        var imgurl = $(this).data('imgbigurl');
        var bigImg = $('.product__details__pic__item--large').attr('src');
        if (imgurl != bigImg) {
            $('.product__details__pic__item--large').attr({
                src: imgurl
            });
        }
    });

    /*-------------------
        Quantity change
    --------------------- */
    var proQty = $('.pro-qty');
    proQty.prepend('<span class="dec qtybtn">-</span>');
    proQty.append('<span class="inc qtybtn">+</span>');
    proQty.on('click', '.qtybtn', function () {
        var totalCartPrice = $('.total-cart-price').text().replace(/[^\d.-]/g, '');
        var $button = $(this);
        var oldValue = $button.parent().find('input').val();
        // var bookPrice =  
        if ($button.hasClass('inc')) {
            var newVal = parseFloat(oldValue) + 1;
        } else {
            // Don't allow decrementing below zero
            if (oldValue > 1) {
                var newVal = parseFloat(oldValue) - 1;
            } else {
                var newVal = 1;
            }
        }

        //Update quantity
        $button.parent().find('input').val(newVal);

        if (totalCartPrice !== "") {
            var bookPrice = $(this).closest(".pro-qty").data("book-price");
            var cartItemId = $(this).closest(".pro-qty").data("cart-item-id");

            //Total Price of Cart Item
            var totalCartItemPrice = bookPrice * newVal;
            //Update Total Price Of Cart Item
            $(this).closest('td').next('.shoping__cart__total').text(formatNumber(totalCartItemPrice));

            //Update Total Price Of Cart
            totalCartPrice = (totalCartPrice - (oldValue * bookPrice)) + totalCartItemPrice;
            $('.total-cart-price').text(formatNumber(totalCartPrice));

            var dataJSON = {
                'cartItemId': cartItemId,
                'quantity': newVal,
                'totalCartItemPrice': totalCartItemPrice,
                'totalCartPrice': totalCartPrice
            };

            if (oldValue != newVal) {
                //Update Cart Item 
                $.ajax({
                    type: 'POST',
                    url: 'http://localhost:8082/api/cart-item',
                    contentType: 'application/json; charset=utf-8',
                    data: JSON.stringify(dataJSON),
                    success: function () {
                        $.toast({
                            heading: 'Giỏ hàng',
                            text: 'Cập nhật thành công.',
                            position: 'top-right',
                            icon: 'success'
                        })
                    },
                    error: function () {
                        $.toast({
                            heading: 'Giỏ hàng',
                            text: 'Cập nhật thất bại.',
                            position: 'top-right',
                            icon: 'error'
                        })
                    }
                });
            }
        }
    });

    /*---------------
        Format Number
    -----------------*/
    function formatNumber(num) {
        const formattedTotal = new Intl.NumberFormat('vi-VN', {
            style: 'currency',
            currency: 'VND'
        }).format(num).replaceAll('.', ',');

        return formattedTotal;
    }

    /*---------------
        Add To Cart
    -----------------*/
    $('#bookList').on('click', '.btnAddToCart', function (event) {
        event.preventDefault();
        var cartId = $('#cartId').val();
        var bookId = $(this).data('book-id');
        var bookCount = $('#bookCount').val();

        if (!bookCount) {
            bookCount = 1;
        }

        if (!cartId) {
            window.location.href = '/login';
        } else {
            sendRequestAddToCart(bookId, bookCount);
        }
    });

    function sendRequestAddToCart(bookId, bookCount) {
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8082/api/cart?bookId=' + bookId + '&' + 'bookCount=' + bookCount,
            contentType: "application/json; charset=utf-8",
            processData: false,
            success: function (response, textStatus, xhr) {
                $.toast({
                    heading: 'Giỏ hàng',
                    text: 'Sản phẩm đã được thêm vào giỏ hàng',
                    position: 'top-right',
                    icon: 'success'
                })
                updateCartCount(JSON.parse(xhr.responseText).data['newCartCount']);
            },
            error: function (xhr, status, error) {
                $.toast({
                    heading: 'Giỏ hàng',
                    text: 'Sản phẩm đã hết hàng',
                    position: 'top-right',
                    icon: 'error'
                })
            }
        });
    }

    function updateCartCount(newCartCount) {
        $('#cartCount').text(newCartCount);
    }

    /*-----------------
        Confirm Logout 
    -------------------*/
    $('.logout').on('click', function (event) {
        event.preventDefault();
        if (confirm("Bạn có chắc chắn muốn đăng xuất không?")) {
            document.getElementById('logoutForm').submit();
        }
    });

    /*-----------------
        Search Form 
    -------------------*/
    $('#formSearch').submit(function (event) {
        event.preventDefault();
        var inputSearch = $('#inputSearch').val();

        window.location.href = "/shop?keyword=" + inputSearch;
    });


})(jQuery);

