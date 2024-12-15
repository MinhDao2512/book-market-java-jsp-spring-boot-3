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
            <!--Title-->
            <title>Story Swap | Sản phẩm</title>

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
            <!--JQuery-->
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        </head>

        <body>
            <!-- Header Section Begin -->
            <jsp:include page="../layout/header.jsp" />
            <!-- Header Section End -->

            <!-- Hero Section Begin -->
            <jsp:include page="../layout/hero-select-another.jsp" />
            <!-- Hero Section End -->

            <!-- Product Section Begin -->
            <section class="product spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center">
                            <h5 style="color: #C5A992;">
                                <a href="/" style="color: #C5A992;"><strong>Trang chủ</strong></a> | Sản phẩm
                            </h5>
                        </div>
                    </div>
                    <div class="filter__item mt-3">
                        <div class="row">
                            <div class="col-lg-3 col-md-5">
                                <div class="sidebar">
                                    <div class="sidebar__item">
                                        <h4>Thể loại</h4>
                                        <ul>
                                            <c:forEach var="category" items="${categories}">
                                                <li><a href="#">${category.description}</a></li>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-9 col-md-7">
                                <div class="row">
                                    <div class="col-lg-4 col-md-5">
                                        <div class="filter__sort">
                                            <span>Sắp xếp</span>
                                            <select>
                                                <option value="0">Phổ biến</option>
                                                <option value="0">Bán chạy</option>
                                                <option value="0">Hàng mới</option>
                                                <option value="0">Giá thấp đến cao</option>
                                                <option value="0">Giá cao đến thấp</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <c:forEach var="book" items="${books}">
                                        <div class="col-lg-4 col-md-6 col-sm-6">
                                            <div class="product__item">
                                                <div class="product__item__pic set-bg"
                                                    data-setbg="/images/book/${book.bookImages[0].name}">
                                                    <ul class="product__item__pic__hover">
                                                        <li><a href="#" class="btnAddToCart"
                                                                data-book-id="${book.id}"><i
                                                                    class="fa fa-shopping-cart"></i></a></li>
                                                    </ul>
                                                </div>
                                                <div class="product__item__text">
                                                    <h6><a href="/shop/${book.id}">${book.title}</a></h6>
                                                    <h5>
                                                        <fmt:formatNumber type="number" value="${book.price}" /> đ
                                                    </h5>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                                <div class="product__pagination text-center">
                                    <c:forEach var="pageNumber" items="${pageNumbers}">
                                        <c:choose>
                                            <c:when test="${pageNumber == currentPage}">
                                                <a href="/shop?page=${pageNumber}" class="active">${pageNumber}</a>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="/shop?page=${pageNumber}">${pageNumber}</a>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                    <c:if test="${totalPages != currentPage}">
                                        <a href="/shop?page=${currentPage+1}"><i class="fa fa-long-arrow-right"></i></a>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Product Section End -->

            <!-- Footer Section Begin -->
            <jsp:include page="../layout/footer.jsp" />
            <!-- Footer Section End -->

            <!-- Js Plugins -->
            <script src="/client/js/bootstrap.min.js"></script>
            <script src="/client/js/jquery.nice-select.min.js"></script>
            <script src="/client/js/jquery-ui.min.js"></script>
            <script src="/client/js/jquery.slicknav.js"></script>
            <script src="/client/js/mixitup.min.js"></script>
            <script src="/client/js/owl.carousel.min.js"></script>
            <script src="/client/js/main.js"></script>
            <!--Jquery Toast Plugin-->
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-toast-plugin/1.3.2/jquery.toast.min.js"></script>
        </body>

        </html>