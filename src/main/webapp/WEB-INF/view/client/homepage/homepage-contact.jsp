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
            <jsp:include page="../layout/hero-select-another.jsp" />
            <!-- Hero Section End -->

            <!-- Contact Section Begin -->
            <section class="contact spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center">
                            <h4 style="color: #C5A992;">
                                <strong>Liên hệ</strong>
                            </h4>
                        </div>
                    </div>
                    <div class="filter__item mt-3">
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
                </div>
            </section>
            <!-- Contact Section End -->

            <!-- Map Begin -->
            <div class="map">
                <iframe
                    src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.521541680388!2d106.78436437451803!3d10.847880157872723!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3175272a49301c55%3A0xde097a8add7a6926!2zOTcgxJAuIE1hbiBUaGnhu4duLCBIaeG7h3AgUGjDuiwgUXXhuq1uIDksIEjhu5MgQ2jDrSBNaW5oLCBWaWV0bmFt!5e0!3m2!1sen!2s!4v1734030122734!5m2!1sen!2s"
                    width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy"
                    referrerpolicy="no-referrer-when-downgrade"></iframe>
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
                                <textarea placeholder="Nội dung"></textarea>
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