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
            <title>Story Swap</title>

            <!-- Google Font -->
            <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
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
            <jsp:include page="../layout/hero-select-home.jsp" />
            <!-- Hero Section End -->

            <!-- Categories Section Begin -->
            <section class="categories">
                <div class="container">
                    <div class="section-title">
                        <h2>Thể Loại</h2>
                    </div>
                    <div class="row">
                        <div class="categories__slider owl-carousel">
                            <div class="col-lg-3">
                                <div class="categories__item set-bg" data-setbg="/images/category/truyen-tranh.jpg">
                                </div>
                                <h5 class="text-center mt-3">
                                    <a href="#"> <strong style="color: black;"> TRUYỆN TRANH </strong> </a>
                                </h5>
                            </div>
                            <div class="col-lg-3">
                                <div class="categories__item set-bg" data-setbg="/images/category/trinh-tham.jpg">
                                </div>
                                <h5 class="text-center mt-3">
                                    <a href="#"> <strong style="color: black;"> TRINH THÁM </strong> </a>
                                </h5>
                            </div>
                            <div class="col-lg-3">
                                <div class="categories__item set-bg" data-setbg="/images/category/khoa-hoc.jpg">
                                </div>
                                <h5 class="text-center mt-3">
                                    <a href="#"> <strong style="color: black;"> KHOA HỌC </strong> </a>
                                </h5>
                            </div>
                            <div class="col-lg-3">
                                <div class="categories__item set-bg" data-setbg="/images/category/kinh-di.jpg">
                                </div>
                                <h5 class="text-center mt-3">
                                    <a href="#"> <strong style="color: black;"> KINH DỊ </strong> </a>
                                </h5>
                            </div>
                            <div class="col-lg-3">
                                <div class="categories__item set-bg" data-setbg="/images/category/lang-man.jpg">
                                </div>
                                <h5 class="text-center mt-3">
                                    <a href="#"> <strong style="color: black;"> LÃNG MẠN </strong> </a>
                                </h5>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Categories Section End -->

            <!-- Featured Section Begin -->
            <section class="featured spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="section-title">
                                <h2>Sản Phẩm</h2>
                            </div>
                            <div class="featured__controls">
                                <ul>
                                    <li class="active" data-filter="*">Tất Cả</li>
                                    <li data-filter=".new">Mới Nhất</li>
                                    <li data-filter=".offer">Ưu Đãi</li>
                                    <li data-filter=".best-seller">Bán Chạy</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="row featured__filter">
                        <c:forEach var="book" items="${books}">
                            <div class="col-lg-3 col-md-4 col-sm-6 mix new offer best-seller">
                                <div class="featured__item">
                                    <div class="featured__item__pic set-bg"
                                        data-setbg="/images/book/${book.bookImages[0].name}">
                                        <ul class="featured__item__pic__hover">
                                            <li><a href="/shop/${book.id}"><i class="fa fa-shopping-cart"></i></a></li>
                                        </ul>
                                    </div>
                                    <div class="featured__item__text">
                                        <h6><a href="/shop/${book.id}">${book.title}</a></h6>
                                        <h5>
                                            <fmt:formatNumber type="number" value="${book.price}" /> đ
                                        </h5>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </section>
            <!-- Featured Section End -->

            <!-- Blog Section Begin -->
            <section class="from-blog spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="section-title from-blog__title">
                                <h2>Bài Viết</h2>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-4 col-md-4 col-sm-6">
                            <div class="blog__item">
                                <div class="blog__item__pic">
                                    <img src="/client/img/blog/blog-1.jpg" alt="">
                                </div>
                                <div class="blog__item__text">
                                    <ul>
                                        <li><i class="fa fa-calendar-o"></i> 13/12/2024</li>
                                        <li><i class="fa fa-comment-o"></i> 5</li>
                                    </ul>
                                    <h5><a href="#">Các mẹo giữ cho sách của bạn luôn mới</a></h5>
                                    <p>TÔI LÀM DEV</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-6">
                            <div class="blog__item">
                                <div class="blog__item__pic">
                                    <img src="/client/img/blog/blog-2.jpg" alt="">
                                </div>
                                <div class="blog__item__text">
                                    <ul>
                                        <li><i class="fa fa-calendar-o"></i> 13/12/2024</li>
                                        <li><i class="fa fa-comment-o"></i> 5</li>
                                    </ul>
                                    <h5><a href="#">6 cách để bắt đầu thói quen đọc sách</a></h5>
                                    <p>TÔI LÀM DEV</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-4 col-sm-6">
                            <div class="blog__item">
                                <div class="blog__item__pic">
                                    <img src="/client/img/blog/blog-3.jpg" alt="">
                                </div>
                                <div class="blog__item__text">
                                    <ul>
                                        <li><i class="fa fa-calendar-o"></i> 13/12/2024</li>
                                        <li><i class="fa fa-comment-o"></i> 5</li>
                                    </ul>
                                    <h5><a href="#">Top 10 điều học được khi đọc cuốn sách "Thay đổi thói quen tí
                                            hon"</a></h5>
                                    <p>TÔI LÀM DEV</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Blog Section End -->

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
        </body>

        </html>