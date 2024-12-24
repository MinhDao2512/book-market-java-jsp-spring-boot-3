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

            <!-- Include CSS NProgress-->
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/nprogress/0.2.0/nprogress.min.css">

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

            <!--Select 2-->
            <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
            <style>
                span.select2-selection--single {
                    display: none !important;
                }
            </style>
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
                        <form id="formFilter">
                            <div class="row">
                                <div class="col-lg-3 col-md-5">
                                    <div class="card" style="border: none;">
                                        <div class="card-header text-center">
                                            <h5><strong>Tất cả bộ lọc</strong></h5>
                                        </div>
                                        <div class="card-body">
                                            <div class="sidebar">
                                                <div class="sidebar__item">
                                                    <h5>Thể loại</h5>
                                                    <select class="js-example-basic-multiple" name="states[]"
                                                        multiple="multiple" style="width: 100%;">
                                                        <c:forEach var="category" items="${categories}">
                                                            <option value="${category.id}">${category.description}
                                                            </option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="sidebar">
                                                <div class="sidebar__item">
                                                    <h5>Tình trạng</h5>
                                                    <div class="sidebar__item">
                                                        <div class="form-check">
                                                            <input class="form-check-input" type="checkbox" value="OLD"
                                                                id="stateOld">
                                                            <label class="form-check-label" for="stateOld">Sách
                                                                cũ</label>
                                                        </div>
                                                        <div class="form-check">
                                                            <input class="form-check-input" type="checkbox" value="NEW"
                                                                id="stateNew">
                                                            <label class="form-check-label" for="stateNew">Sách
                                                                mới</label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="sidebar">
                                                <div class="sidebar__item">
                                                    <h5>Giá</h5>
                                                    <div class="form-check">
                                                        <input class="form-check-input" type="checkbox" value="lt100000"
                                                            id="priceRangeLt100000">
                                                        <label class="form-check-label" for="priceRangeLt100000">
                                                            Giá dưới 100.000 đ
                                                        </label>
                                                    </div>
                                                    <div class="form-check">
                                                        <input class="form-check-input" type="checkbox"
                                                            value="100000-500000" id="priceRange100000to500000">
                                                        <label class="form-check-label" for="priceRange100000to500000">
                                                            100.000 đ - 500.000 đ
                                                        </label>
                                                    </div>
                                                    <div class="form-check">
                                                        <input class="form-check-input" type="checkbox"
                                                            value="500000-1000000" id="priceRange500000to1000000">
                                                        <label class="form-check-label" for="priceRange500000to1000000">
                                                            500.000 đ - 1.000.000 đ
                                                        </label>
                                                    </div>
                                                    <div class="form-check">
                                                        <input class="form-check-input" type="checkbox"
                                                            value="gt1000000" id="priceRangeGt1000000">
                                                        <label class="form-check-label" for="priceRangeGt1000000">
                                                            Giá trên 1.000.000 đ
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="sidebar text-center">
                                        <div class="sidebar__item">
                                            <button class="btn btn-outline-info" id="filterBtn">Xem kết quả</button>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-9 col-md-7">
                                    <div class="row">
                                        <div class="col-lg-4 col-md-5">
                                            <div class="filter__sort">
                                                <span>Sắp xếp</span>
                                                <select id="sortBy">
                                                    <option value="AZ" selected>Tên từ A &rarr; Z</option>
                                                    <option value="ZA">Tên từ Z &rarr; A</option>
                                                    <option value="PRICE_ASC">Giá thấp đến cao</option>
                                                    <option value="PRICE_DESC">Giá cao đến thấp</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row mt-3" id="bookList">
                                    </div>
                                    <div class="product__pagination text-center">
                                        <button class="btn btn-outline-info" id="loadMoreBtn">Xem thêm</button>
                                    </div>
                                </div>
                            </div>
                        </form>
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
            <!--Select 2-->
            <script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
            <!-- Include JS NProgress-->
            <script src="https://cdnjs.cloudflare.com/ajax/libs/nprogress/0.2.0/nprogress.min.js"></script>
            <script>
                NProgress.start();

                window.onload = function () {
                    NProgress.done();
                };

                var currentPage = 1;
                var totalPages = 0;

                $(document).ready(function () {

                    $('.js-example-basic-multiple').select2();

                    loadMoreProducts(currentPage, true);

                    function loadMoreProducts(page, isFirstLoad) {
                        NProgress.start();

                        var keyword = $('#inputSearch').val();
                        var sortBy = $('#sortBy').val();
                        var categories = getSelectedCategories();
                        var states = getCheckedStates();
                        var prices = getCheckedPrices();

                        $.ajax({
                            url: '/shop/search',  // URL của API
                            method: 'GET',
                            data: {
                                page: page,
                                keyword: keyword,
                                categories: categories,
                                states: states,
                                prices: prices,
                                sortBy: sortBy
                            },
                            success: function (data) {
                                var dataMap = data.data;
                                totalPages = dataMap['totalPages'];

                                var productHtml = '';

                                if (!dataMap['data'] || dataMap['data'].length === 0) {
                                    $('#loadMoreBtn').hide();
                                } else {
                                    dataMap['data'].forEach(function (book) {
                                        var bookImageUrl = '/images/book/' + book.bookImages[0].name;
                                        var truncatedTitle = book.title.length > 30 ? book.title.slice(0, 30) + '...' : book.title;

                                        productHtml += '<div class="col-lg-4 col-md-6 col-sm-6">' +
                                            '<div class="product__item">' +
                                            '<div class="product__item__pic set-bg" data-setbg="' + bookImageUrl + '" style="background-image: url(' + bookImageUrl + ');">' +
                                            '<ul class="product__item__pic__hover">' +
                                            '<li><a href="#" class="btnAddToCart" data-book-id="' + book.id + '"><i class="fa fa-shopping-cart"></i></a></li>' +
                                            '</ul>' +
                                            '</div>' +
                                            '<div class="product__item__text">' +
                                            '<h6><a href="/shop/' + book.id + '" data-bs-toggle="tooltip" data-bs-placement="top" title="' + book.title + '">' + truncatedTitle + '</a></h6>' +
                                            '<h5 style="color: rgb(255, 66, 78);">' + book.price.toLocaleString('vi-VN').replace(/\./g, ',') + ' đ</h5>' +
                                            '</div>' +
                                            '</div>' +
                                            '</div>';
                                    });
                                }

                                if (isFirstLoad) {
                                    $('#bookList').html(productHtml); // Lần đầu, thay toàn bộ nội dung
                                } else {
                                    $('#bookList').append(productHtml); // Các lần sau, thêm nội dung
                                }

                                if (currentPage >= totalPages) {
                                    $('#loadMoreBtn').hide();
                                } else {
                                    $('#loadMoreBtn').show();
                                }

                                NProgress.done();
                            },
                            error: function () {
                                alert("Lỗi khi tải dữ liệu.");
                                NProgress.done();
                            }
                        });
                    }

                    //Get List Selected Categories
                    function getSelectedCategories() {
                        var selectedCategories = $('.js-example-basic-multiple').val(); // Lấy giá trị từ select
                        return selectedCategories;
                    }

                    //Get List Checked States
                    function getCheckedStates() {
                        var selectedStates = [];
                        $('.form-check-input:checked').each(function () {
                            var id = $(this).attr('id');
                            var value = $(this).val();
                            if (id.includes('state')) {
                                selectedStates.push(value);
                            }
                        });
                        return selectedStates;
                    }

                    //Get List Checked Prices
                    function getCheckedPrices() {
                        var selectedPrices = [];
                        $('.form-check-input:checked').each(function () {
                            var id = $(this).attr('id');
                            var value = $(this).val();
                            if (id.includes('priceRange')) {
                                selectedPrices.push(value);
                            }
                        });
                        return selectedPrices;
                    }

                    //CHeck Btn Load More Click
                    $('#loadMoreBtn').click(function (event) {
                        event.preventDefault();
                        var page = currentPage + 1;
                        ++currentPage;
                        loadMoreProducts(page, false);
                    });

                    //Check Btn Filter Click
                    $('#filterBtn').click(function (event) {
                        event.preventDefault();
                        currentPage = 1;
                        loadMoreProducts(currentPage, true);
                    });

                    //Check Sort By Change
                    $('#sortBy').change(function () {
                        event.preventDefault();
                        currentPage = 1;
                        loadMoreProducts(currentPage, true);
                    });
                });
            </script>
        </body>

        </html>