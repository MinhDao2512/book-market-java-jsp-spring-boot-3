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
            <section class="hero">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3">
                            <div class="hero__categories">
                                <div class="hero__categories__all">
                                    <i class="fa fa-bars"></i>
                                    <span>Danh mục</span>
                                </div>
                                <ul>
                                    <li><a href="#">English Books</a></li>
                                    <li><a href="#">Sách tiếng Việt</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-9">
                            <div class="hero__search">
                                <div class="hero__search__form">
                                    <form action="#">
                                        <div class="hero__search__categories">
                                            Tất cả danh mục
                                            <span class="arrow_carrot-down"></span>
                                        </div>
                                        <input type="text" placeholder="Bạn cần tìm sản phẩm gì?">
                                        <button type="submit" class="site-btn">TÌM
                                            KIẾM</button>
                                    </form>
                                </div>
                                <div class="hero__search__phone">
                                    <div class="hero__search__phone__icon">
                                        <i class="fa fa-phone"></i>
                                    </div>
                                    <div class="hero__search__phone__text">
                                        <h5>(+84) 942 236 357</h5>
                                        <span>Hỗ trợ 24/7</span>
                                    </div>
                                </div>
                            </div>
                            <div class="hero__item set-bg" data-setbg="/images/banner/banner.jpg">
                                <div class="hero__text">
                                    <h2>Story Swap</h2>
                                    <p>Miễn phí vẫn chuyển cho hóa đơn trên 300.000đ</p>
                                    <a href="/shop" class="primary-btn">MUA NGAY</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Hero Section End -->

            <!-- Categories Section Begin -->
            <section class="categories">
                <div class="container">
                    <div class="row">
                        <div class="categories__slider owl-carousel">
                            <div class="col-lg-3">
                                <div class="categories__item set-bg" data-setbg="/client/img/categories/cat-1.jpg">
                                    <h5><a href="#">Fresh Fruit</a></h5>
                                </div>
                            </div>
                            <div class="col-lg-3">
                                <div class="categories__item set-bg" data-setbg="/client/img/categories/cat-2.jpg">
                                    <h5><a href="#">Dried Fruit</a></h5>
                                </div>
                            </div>
                            <div class="col-lg-3">
                                <div class="categories__item set-bg" data-setbg="/client/img/categories/cat-3.jpg">
                                    <h5><a href="#">Vegetables</a></h5>
                                </div>
                            </div>
                            <div class="col-lg-3">
                                <div class="categories__item set-bg" data-setbg="/client/img/categories/cat-4.jpg">
                                    <h5><a href="#">drink fruits</a></h5>
                                </div>
                            </div>
                            <div class="col-lg-3">
                                <div class="categories__item set-bg" data-setbg="/client/img/categories/cat-5.jpg">
                                    <h5><a href="#">drink fruits</a></h5>
                                </div>
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
                                            <li><a href="#"><i class="fa fa-heart"></i></a></li>
                                            <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                                            <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                                        </ul>
                                    </div>
                                    <div class="featured__item__text">
                                        <h6><a href="#">${book.title}</a></h6>
                                        <h5>${book.price}</h5>
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
                                        <li><i class="fa fa-calendar-o"></i> May 4,2019</li>
                                        <li><i class="fa fa-comment-o"></i> 5</li>
                                    </ul>
                                    <h5><a href="#">Cooking tips make cooking simple</a></h5>
                                    <p>Sed quia non numquam modi tempora indunt ut labore et dolore magnam aliquam
                                        quaerat </p>
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
                                        <li><i class="fa fa-calendar-o"></i> May 4,2019</li>
                                        <li><i class="fa fa-comment-o"></i> 5</li>
                                    </ul>
                                    <h5><a href="#">6 ways to prepare breakfast for 30</a></h5>
                                    <p>Sed quia non numquam modi tempora indunt ut labore et dolore magnam aliquam
                                        quaerat </p>
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
                                        <li><i class="fa fa-calendar-o"></i> May 4,2019</li>
                                        <li><i class="fa fa-comment-o"></i> 5</li>
                                    </ul>
                                    <h5><a href="#">Visit the clean farm in the US</a></h5>
                                    <p>Sed quia non numquam modi tempora indunt ut labore et dolore magnam aliquam
                                        quaerat </p>
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