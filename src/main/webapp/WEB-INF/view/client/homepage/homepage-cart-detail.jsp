<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@include file="/resources/taglib.jsp" %>
        <!DOCTYPE html>
        <html lang="zxx">

        <head>
            <meta charset="UTF-8">
            <meta name="description" content="Ogani Template">
            <meta name="keywords" content="Ogani, unica, creative, html">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta http-equiv="X-UA-Compatible" content="ie=edge">
            <title>Story Swap | Giỏ hàng</title>

            <!-- Google Font -->
            <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
                rel="stylesheet">

            <!--Jquery Toast Plugin-->
            <link href="https://cdnjs.cloudflare.com/ajax/libs/jquery-toast-plugin/1.3.2/jquery.toast.min.css"
                rel="stylesheet">
            <!--Bootstrap 4.4.1-->
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
                integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
                crossorigin="anonymous">
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
                integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
                crossorigin="anonymous"></script>


            <!-- Css Styles -->
            <link rel="stylesheet" href="/client/css/bootstrap.min.css" type="text/css">
            <link rel="stylesheet" href="/client/css/font-awesome.min.css" type="text/css">
            <link rel="stylesheet" href="/client/css/elegant-icons.css" type="text/css">
            <link rel="stylesheet" href="/client/css/nice-select.css" type="text/css">
            <link rel="stylesheet" href="/client/css/jquery-ui.min.css" type="text/css">
            <link rel="stylesheet" href="/client/css/owl.carousel.min.css" type="text/css">
            <link rel="stylesheet" href="/client/css/slicknav.min.css" type="text/css">
            <link rel="stylesheet" href="/client/css/style.css" type="text/css">
        </head>

        <body>
            <!-- Header Section Begin -->
            <jsp:include page="../layout/header.jsp" />
            <!-- Header Section End -->

            <!-- Hero Section Begin -->
            <jsp:include page="../layout/hero-select-another.jsp" />
            <!-- Hero Section End -->

            <!-- Breadcrumb Section Begin -->
            <section class="breadcrumb-section set-bg" data-setbg="/client/img/breadcrumb.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center">
                            <div class="breadcrumb__text">
                                <h2>Giỏ hàng</h2>
                                <div class="breadcrumb__option">
                                    <a href="/">Trang chủ</a>
                                    <span>Giỏ hàng</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Breadcrumb Section End -->

            <!-- Shoping Cart Section Begin -->
            <section class="shoping-cart spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="shoping__cart__table">
                                <table>
                                    <thead>
                                        <tr>
                                            <th>Hình ảnh</th>
                                            <th>Sản phẩm</th>
                                            <th>Giá tiền</th>
                                            <th>Số lượng</th>
                                            <th>Tổng tiền</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="cartItem" items="${cartItems}">
                                            <tr data-cart-item-id="${cartItem.id}">
                                                <td>
                                                    <a href="/shop/${cartItem.book.id}">
                                                        <img src="/images/book/${cartItem.book.bookImages[0].name}"
                                                            style="width: 100px;">
                                                    </a>
                                                </td>
                                                <td class="col-md-6"
                                                    style="white-space: normal; word-wrap: break-word; overflow: visible;">
                                                    <h5>
                                                        <a href="/shop/${cartItem.book.id}"
                                                            style="background-color: white; color: black; text-decoration: none; display: inline-block;">${cartItem.book.title}</a>
                                                    </h5>
                                                </td>
                                                <td class="shoping__cart__price">
                                                    <fmt:formatNumber type="number" value="${cartItem.book.price}" />
                                                </td>
                                                <td class="shoping__cart__quantity">
                                                    <div class="quantity">
                                                        <div class="pro-qty" data-book-price="${cartItem.book.price}"
                                                            data-cart-item-id="${cartItem.id}">
                                                            <input type="text" value="${cartItem.quantity}"
                                                                class="input-quantity">
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="shoping__cart__total">
                                                    <fmt:formatNumber type="number" value="${cartItem.totalPrice}" /> đ
                                                </td>
                                                <td class="shoping__cart__item__close">
                                                    <span class="icon_close btnDeleteCartItem"
                                                        data-cart-item-id="${cartItem.id}"></span>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                                <c:if test="${sessionScope.cartCount == 0}">
                                    <h6 class="mt-3" style="color: red; text-align: center">
                                        Bạn chưa có sản phẩm nào trong giỏ hàng !
                                    </h6>
                                </c:if>
                            </div>
                        </div>
                    </div>
                    <div class=" row">
                        <div class="col-lg-12">
                            <div class="shoping__cart__btns">
                                <a href="/shop" class="primary-btn cart-btn">THÊM SẢN PHẨM KHÁC</a>
                            </div>
                        </div>
                        <div class="col-lg-7">
                        </div>
                        <div class="col-lg-5">
                            <div class="shoping__checkout">
                                <h5>Giỏ Hàng</h5>
                                <ul>
                                    <li>Tổng:
                                        <span class="total-cart-price">
                                            <fmt:formatNumber type="number" value="${sessionScope.totalCartPrice}" /> đ
                                        </span>
                                    </li>
                                </ul>
                                <c:if test="${sessionScope.cartCount != 0}">
                                    <a href="/checkout" class="primary-btn">TIẾN HÀNH THANH TOÁN</a>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Shoping Cart Section End -->

            <!-- Footer Section Begin -->
            <jsp:include page="../layout/footer.jsp" />
            <!-- Footer Section End -->

            <!-- Js Plugins -->
            <script src="/client/js/jquery-3.3.1.min.js"></script>
            <script src="/client/js/bootstrap.min.js"></script>
            <script src="/client/js/jquery.nice-select.min.js"></script>
            <script src="/client/js/jquery-ui.min.js"></script>
            <script src="/client/js/jquery.slicknav.js"></script>
            <script src="/client/js/mixitup.min.js"></script>
            <script src="/client/js/owl.carousel.min.js"></script>
            <script src="/client/js/main.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-toast-plugin/1.3.2/jquery.toast.min.js"></script>
            <script>
                $('.btnDeleteCartItem').on('click', function () {
                    var cartItemId = $(this).data('cart-item-id');
                    var object = {
                        'cartItemId': cartItemId
                    };
                    //Call API Delete
                    sendAJAXRequest(object);
                    //Update Total Cart Price
                    var totalCartPrice = $('.total-cart-price').text().replace(/[^\d.-]/g, '');
                    var totalCartItemPrice = $(this).closest('tr').find('.shoping__cart__total').text().replace(/[^\d.-]/g, '');
                    totalCartPrice = new Intl.NumberFormat('vi-VN', {
                        style: 'currency',
                        currency: 'VND'
                    }).format(totalCartPrice - totalCartItemPrice).replaceAll('.', ',');

                    $('.total-cart-price').text(totalCartPrice);
                    //update cart count
                    var oldCartCount = $('#cartCount').text();
                    $('#cartCount').text(oldCartCount - 1);
                });

                function sendAJAXRequest(object) {
                    $.ajax({
                        type: 'DELETE',
                        url: 'http://localhost:8082/api/cart-item',
                        contentType: 'application/json; charset=utf-8',
                        data: JSON.stringify(object),
                        success: function () {
                            $('tr[data-cart-item-id="' + object['cartItemId'] + '"]').hide();
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
                                icon: 'success'
                            })
                        }
                    });
                } 
            </script>
        </body>

        </html>