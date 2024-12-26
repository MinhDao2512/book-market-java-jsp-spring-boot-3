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
            <title>Sản phẩm | ${currentBook.title}</title>

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

            <section class="product-details spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="breadcrumb__option">
                                <a href="/shop" style="color: #C5A992;"> Sản phẩm </a>
                                <c:choose>
                                    <c:when test="${fn:length(currentBook.title) > 50}">
                                        <span>${fn:substring(currentBook.title, 0, 50)}...</span>
                                    </c:when>
                                    <c:otherwise>
                                        ${currentBook.title}
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                    <div class="filter__item mt-3">
                        <div class="row">
                            <div class="col-lg-6 col-md-6">
                                <div class="product__details__pic">
                                    <div class="product__details__pic__item">
                                        <img class="product__details__pic__item--large"
                                            src="/images/book/${currentBook.bookImages[0].name}" alt="">
                                    </div>
                                    <div class="product__details__pic__slider owl-carousel">
                                        <c:forEach var="bookImage" items="${currentBook.bookImages}">
                                            <img src="/images/book/${bookImage.name}" alt="">
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6">
                                <div class="product__details__text">
                                    <h3>${currentBook.title}</h3>
                                    <div class="product__details__rating">
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star-half-o"></i>
                                        <span>(18 đánh giá) </span>
                                    </div>
                                    <div class="product__details__price">
                                        <fmt:formatNumber type="number" value="${currentBook.price}" /> đ
                                    </div>
                                    <c:if test="${currentBook.quantity > 0}">
                                        <p><b>Tình trạng: </b> Còn hàng</p>
                                    </c:if>
                                    <c:if test="${currentBook.quantity == 0}">
                                        <p><b>Tình trạng: </b> Hết hàng</p>
                                    </c:if>
                                    <p><b>Đã bán: </b> ${currentBook.sold}</p>
                                    <div id="bookList">
                                        <div class="product__details__quantity">
                                            <div class="quantity">
                                                <div class="pro-qty">
                                                    <input type="text" value="1" id="bookCount">
                                                </div>
                                            </div>
                                        </div>
                                        <c:if test="${empty sessionScope.cartId}">
                                            <a href="/login" class="primary-btn">Mua ngay</a>
                                            <a href="/login" class="primary-btn btnAddToCart"
                                                data-book-id="${currentBook.id}">Thêm vào giỏ</a>
                                        </c:if>
                                        <c:if test="${not empty sessionScope.cartId}">
                                            <a href="#" class="primary-btn" data-book-id="${currentBook.id}"
                                                id="buy-now">Mua ngay</a>
                                            <a href="#" class="primary-btn btnAddToCart"
                                                data-book-id="${currentBook.id}">Thêm vào giỏ</a>
                                        </c:if>
                                    </div>
                                    <ul>
                                        <h3>Thông tin chi tiết</h3>
                                        <li><b>Công ty phát hành</b> <span>${currentBook.publishingCompany}</span></li>
                                        <li><b>Ngày xuất bản</b> <span>${currentBook.publicationDate}</span></li>
                                        <li>
                                            <b>Nhà xuất bản</b> <span>Nhà Xuất Bản ${currentBook.publisher.name}</span>
                                        </li>
                                        <li><b>Dịch Giả</b> <span>${currentBook.translator}</span></li>
                                        <li><b>Kích thước</b> <span>${currentBook.size}</span></li>
                                        <li><b>Số trang</b> <span>${currentBook.numberOfPages}</span></li>
                                        <li><b>Loại bìa</b> <span>${currentBook.coverType}</span></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-lg-12">
                                <div class="product__details__tab">
                                    <ul class="nav nav-tabs" role="tablist">
                                        <li class="nav-item">
                                            <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab"
                                                aria-selected="true">Giới thiệu sách</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab"
                                                aria-selected="false">Đánh giá <span>(1)</span></a>
                                        </li>
                                    </ul>
                                    <div class="tab-content">
                                        <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                            <div class="product__details__tab__desc">
                                                <h6>Mô Tả</h6>
                                                <p>${currentBook.description}</p>
                                            </div>
                                        </div>
                                        <div class="tab-pane" id="tabs-3" role="tabpanel">
                                            <div class="product__details__tab__desc">
                                                <h6>vuive0602</h6>
                                                <p>Sách hay lắm mọi người. Nên đọc nha!</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Product Details Section End -->

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
            <!--Jquery Toast Plugin-->
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-toast-plugin/1.3.2/jquery.toast.min.js"></script>
            <script>
                $(document).ready(function () {
                    $('#buy-now').on('click', function (event) {
                        event.preventDefault();

                        var quantity = $('#bookCount').val();
                        var bookId = $(this).data('book-id');

                        window.location.href = '/checkout/buy-now?bookId=' + bookId + '&quantity=' + quantity;
                    });
                });
            </script>
        </body>

        </html>