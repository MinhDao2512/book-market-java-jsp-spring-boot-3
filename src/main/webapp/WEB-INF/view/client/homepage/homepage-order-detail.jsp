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
            <title>Story Swap | Đơn hàng | Chi tiết đơn hàng</title>

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

            <!-- Shoping Cart Section Begin -->
            <section class="shoping-cart spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center">
                            <h5 style="color: #C5A992;">
                                <a href="/" style="color: #C5A992;"><strong>Đơn hàng</strong> | ${orderCode}
                            </h5>
                        </div>
                    </div>
                    <div class="filter__item mt-3">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="shoping__cart__table">
                                    <table class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Hình sản phẩm</th>
                                                <th>Tên sản phẩm</th>
                                                <th>Giá sản phẩm</th>
                                                <th>Số lượng</th>
                                                <th>Tổng tiền</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="orderItem" items="${orderItems}">
                                                <tr>
                                                    <td>
                                                        ${orderItem.id}
                                                    </td>
                                                    <td class="col-md-2">
                                                        <a href="/shop/${orderItem.book.id}" target="_blank">
                                                            <img src="/images/book/${orderItem.book.bookImages[0].name}"
                                                                alt="Avatar" class="avatar-xs" data-bs-toggle="tooltip"
                                                                data-popup="tooltip-custom" data-bs-placement="top"
                                                                title="Avatar" style="width: 80px; height: 80px;" />
                                                        </a>
                                                    </td>
                                                    <td style="word-wrap: break-word; word-break: break-word;"
                                                        class="text-left">
                                                        <a href="/shop/${orderItem.book.id}" style="color: #C5A992;"
                                                            target="_blank">${orderItem.book.title}</a>
                                                    </td>
                                                    <td class="text-center col-auto">
                                                        <fmt:formatNumber type="number"
                                                            value="${orderItem.book.price}" />&nbsp;đ
                                                    </td>
                                                    <td>
                                                        ${orderItem.quantity}
                                                    </td>
                                                    <td class="text-center col-auto">
                                                        <fmt:formatNumber type="number"
                                                            value="${orderItem.totalPrice}" />&nbsp;đ
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class=" row">
                        <div class="col-lg-12">
                            <div class="shoping__cart__btns">
                                <c:if test="${empty orderItems}">
                                    <a href="/" class="primary-btn cart-btn">
                                        <i class="fa fa-arrow-left" aria-hidden="true"></i> Trang chủ
                                    </a>
                                </c:if>
                                <c:if test="${not empty orderItems}">
                                    <a href="/orders" class="primary-btn cart-btn">
                                        <i class="fa fa-arrow-left" aria-hidden="true"></i> Đơn hàng
                                    </a>
                                </c:if>
                            </div>
                        </div>
                        <div class="col-lg-7">
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
        </body>

        </html>