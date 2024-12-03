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
            <title>Story Swap | Liên hệ</title>

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
            <section class="hero hero-normal">
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
                        </div>
                    </div>
                </div>
            </section>
            <!-- Hero Section End -->

            <!-- Breadcrumb Section Begin -->
            <section class="breadcrumb-section set-bg" data-setbg="/client/img/breadcrumb.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center">
                            <div class="breadcrumb__text">
                                <h2>Liên Hệ</h2>
                                <div class="breadcrumb__option">
                                    <a href="/">Trang chủ</a>
                                    <span>Liên hệ</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Breadcrumb Section End -->

            <!-- Contact Section Begin -->
            <section class="contact spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3 col-md-3 col-sm-6 text-center">
                            <div class="contact__widget">
                                <span class="icon_phone"></span>
                                <h4>Điện thoại</h4>
                                <p>(+84) 942 236 357</p>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-6 text-center">
                            <div class="contact__widget">
                                <span class="icon_pin_alt"></span>
                                <h4>Địa chỉ</h4>
                                <p>Triệu Tài, Triệu Phong, Quảng Trị</p>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-6 text-center">
                            <div class="contact__widget">
                                <span class="icon_clock_alt"></span>
                                <h4>Thời gian mở cửa</h4>
                                <p>09:00 đến 23:00</p>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-6 text-center">
                            <div class="contact__widget">
                                <span class="icon_mail_alt"></span>
                                <h4>Email</h4>
                                <p>nguyenminhdao002@gmail.com</p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Contact Section End -->

            <!-- Map Begin -->
            <div class="map">
                <iframe
                    src="https://www.google.com/maps/place/97+%C4%90.+Man+Thi%E1%BB%87n,+Hi%E1%BB%87p+Ph%C3%BA,+Qu%E1%BA%ADn+9,+H%E1%BB%93+Ch%C3%AD+Minh,+Vietnam/@10.8478802,106.7843644,17z/data=!3m1!4b1!4m6!3m5!1s0x3175272a49301c55:0xde097a8add7a6926!8m2!3d10.8478749!4d106.7869393!16s%2Fg%2F11tsh4vv47?entry=ttu&g_ep=EgoyMDI0MTAyOS4wIKXMDSoASAFQAw%3D%3D"
                    height="500" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
                <div class="map-inside">
                    <i class="icon_pin"></i>
                    <div class="inside-widget">
                        <h4>97 Man Thiện</h4>
                        <ul>
                            <li>Phone: (+84) 942 236 357</li>
                            <li>Add: 97 Man Thiện, Phước Long B</li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- Map End -->

            <!-- Contact Form Begin -->
            <div class="contact-form spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="contact__form__title">
                                <h2>Lời nhắn</h2>
                            </div>
                        </div>
                    </div>
                    <form action="#">
                        <div class="row">
                            <div class="col-lg-6 col-md-6">
                                <input type="text" placeholder="Họ Và Tên">
                            </div>
                            <div class="col-lg-6 col-md-6">
                                <input type="text" placeholder="Địa chỉ Email">
                            </div>
                            <div class="col-lg-12 text-center">
                                <textarea placeholder="Your message"></textarea>
                                <button type="submit" class="site-btn">GỬI LỜI NHẮN</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <!-- Contact Form End -->

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