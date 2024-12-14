<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@include file="/resources/taglib.jsp" %>
        <!DOCTYPE html>
        <html lang="en" class="light-style layout-menu-fixed" dir="ltr" data-theme="theme-default"
            data-assets-path="/admin/" data-template="vertical-menu-template-free">

        <head>
            <meta charset="utf-8" />
            <meta name="viewport"
                content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

            <title>StorySwap.vn | Bảng đơn hàng</title>

            <meta name="description" content="" />

            <!-- Favicon -->
            <link rel="icon" type="image/x-icon" href="/admin/img/favicon/favicon.ico" />

            <!-- Fonts -->
            <link rel="preconnect" href="https://fonts.googleapis.com" />
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
            <link
                href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
                rel="stylesheet" />
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />

            <!-- Icons. Uncomment required icon fonts -->
            <link rel="stylesheet" href="/admin/vendor/fonts/boxicons.css" />

            <!-- Core CSS -->
            <link rel="stylesheet" href="/admin/vendor/css/core.css" class="template-customizer-core-css" />
            <link rel="stylesheet" href="/admin/vendor/css/theme-default.css" class="template-customizer-theme-css" />
            <link rel="stylesheet" href="/admin/css/demo.css" />

            <!-- Vendors CSS -->
            <link rel="stylesheet" href="/admin/vendor/libs/perfect-scrollbar/perfect-scrollbar.css" />

            <link rel="stylesheet" href="/admin/vendor/libs/apex-charts/apex-charts.css" />

            <!-- Page CSS -->

            <!-- Helpers -->
            <script src="/admin/vendor/js/helpers.js"></script>

            <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
            <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
            <script src="/admin/js/config.js"></script>
        </head>

        <body>
            <!-- Layout wrapper -->
            <div class="layout-wrapper layout-content-navbar">
                <div class="layout-container">

                    <jsp:include page="../layout/menu.jsp" />

                    <!-- Layout container -->
                    <div class="layout-page">
                        <jsp:include page="../layout/header.jsp" />

                        <!-- Content wrapper -->
                        <div class="content-wrapper">
                            <!-- Content -->
                            <div class="container-xxl flex-grow-1 container-p-y">
                                <div class="d-flex justify-content-between">
                                    <h4 class="fw-bold py-3 mb-4">
                                        <span class="text-muted fw-light">Quản Lý Đơn Hàng /</span> Đơn Hàng
                                    </h4>
                                </div>
                                <!-- Basic Bootstrap Table -->
                                <div class="card">
                                    <input type="hidden" data-orders-active="1" id="ordersActive" />
                                    <h5 class="card-header">Bảng Đơn Hàng: </h5>
                                    <div>
                                        <c:if test="${empty books}">
                                            <table class="table table-bordered table-striped">
                                                <thead>
                                                    <tr>
                                                        <th class="text-center">ID</th>
                                                        <th class="text-center">Mã đơn hàng</th>
                                                        <th class="text-center">Thông tin nhận hàng</th>
                                                        <th class="text-center">Ngày khởi tạo</th>
                                                        <th class="text-center">Trạng thái đơn hàng</th>
                                                        <th class="text-center">Thanh toán</th>
                                                        <th class="text-center">Tổng tiền</th>
                                                        <th class="text-center">Tác vụ</th>
                                                    </tr>
                                                </thead>
                                                <tbody class="table-border-bottom-0">
                                                    <c:forEach var="order" items="${orders}">
                                                        <tr>
                                                            <td>
                                                                <strong>${order.id}</strong>
                                                            </td>
                                                            <td style="word-wrap: break-word; word-break: break-word;">
                                                                <a
                                                                    href="/admin/orders/detail/${order.id}">${order.paymentRef}</a>
                                                            </td>
                                                            <td class="col-md-2">
                                                                <p><strong>Tên: </strong>${order.receiverName}</p>
                                                                <p><strong>Địa chỉ: </strong>${order.shippingAddress}
                                                                </p>
                                                                <p><strong>Điện thoại: </strong>${order.receiverPhone}
                                                                </p>
                                                            </td>
                                                            <td>
                                                                <fmt:formatDate type="both"
                                                                    value="${order.createdAt}" />
                                                            </td>
                                                            <td class="text-center">
                                                                <span
                                                                    class="badge bg-label-info me-1">${order.status}</span>
                                                            </td>
                                                            <td>
                                                                <p><strong>Phương thức: </strong>${order.paymentMethod}
                                                                </p>
                                                                <p><strong>Trạng thái: </strong>${order.paymentStatus}
                                                                </p>
                                                            </td>
                                                            <td class="col-auto text-center">
                                                                <fmt:formatNumber type="number"
                                                                    value="${order.totalPrice}" />&nbsp;đ
                                                            </td>
                                                            <td class="col-md-3 text-center">
                                                                <a href="/admin/orders/detail/${order.id}"
                                                                    class="btn btn-outline-info" title="Xem chi tiết">
                                                                    <i class="far fa-sticky-note"></i>
                                                                    Xem
                                                                </a>
                                                                <a href="/admin/authors/update/${author.id}"
                                                                    class="btn btn-outline-warning" title="Cập nhật">
                                                                    <i class="fas fa-pencil-alt"></i>
                                                                    Sửa
                                                                </a>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </c:if>
                                        <c:if test="${not empty books}">
                                            <table class="table table-bordered table-striped">
                                                <thead>
                                                    <tr>
                                                        <th class="text-center">ID</th>
                                                        <th class="text-center">Ngày khởi tạo</th>
                                                        <th class="text-center">Mã đơn hàng</th>
                                                        <th class="text-center">Tên sản phẩm</th>
                                                        <th class="text-center">Giá tiền</th>
                                                        <th class="text-center">Số lượng</th>
                                                        <th class="text-center">Tổng tiền</th>
                                                        <th class="text-center">Thông tin nhận hàng</th>
                                                        <th class="text-center">Thanh toán</th>
                                                    </tr>
                                                </thead>
                                                <tbody class="table-border-bottom-0">
                                                    <c:forEach var="book" items="${books}">
                                                        <c:forEach var="orderItem" items="${book.orderItems}">
                                                            <tr>
                                                                <td>
                                                                    <strong>${orderItem.id}</strong>
                                                                </td>
                                                                <td>
                                                                    <fmt:formatDate type="both"
                                                                        value="${orderItem.order.createdAt}" />
                                                                </td>
                                                                <td
                                                                    style="word-wrap: break-word; word-break: break-word;">
                                                                    ${orderItem.order.paymentRef}
                                                                </td>
                                                                <td
                                                                    style="word-wrap: break-word; word-break: break-word;">
                                                                    ${orderItem.book.title}
                                                                </td>
                                                                <td class="col-auto text-center">
                                                                    <fmt:formatNumber type="number"
                                                                        value="${orderItem.book.price}" />&nbsp;đ
                                                                </td>
                                                                <td class="text-center">
                                                                    ${orderItem.quantity}
                                                                </td>
                                                                <td class="col-auto text-center">
                                                                    <fmt:formatNumber type="number"
                                                                        value="${orderItem.totalPrice}" />&nbsp;đ
                                                                </td>
                                                                <td class="col-md-2">
                                                                    <p><strong>Tên:
                                                                        </strong>${orderItem.order.receiverName}</p>
                                                                    <p><strong>Địa chỉ:
                                                                        </strong>${orderItem.order.shippingAddress}
                                                                    </p>
                                                                    <p><strong>Điện thoại:
                                                                        </strong>${orderItem.order.receiverPhone}
                                                                    </p>
                                                                </td>
                                                                <td>
                                                                    <p><strong>Phương thức:
                                                                        </strong>${orderItem.order.paymentMethod}
                                                                    </p>
                                                                    <p><strong>Trạng thái:
                                                                        </strong>${orderItem.order.paymentStatus}
                                                                    </p>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </c:if>
                                    </div>
                                </div>
                                <!--/ Basic Bootstrap Table -->
                            </div>
                            <!--Pagination-->
                            <nav aria-label="...">
                                <ul class="pagination justify-content-center">
                                    <c:choose>
                                        <c:when test="${currentPage == 1}">
                                            <li class="page-item disabled">
                                                <a class="page-link"></a>
                                            </li>
                                        </c:when>
                                        <c:otherwise>
                                            <li class="page-item">
                                                <a class="page-link" href="/admin/orders?page=${currentPage-1}"
                                                    title="Trước">
                                                    <strong>&laquo;</strong>
                                                </a>
                                            </li>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:forEach var="pageNumber" items="${pageNumbers}">
                                        <c:choose>
                                            <c:when test="${pageNumber == currentPage}">
                                                <li class="page-item active" aria-current="page">
                                                    <a class="page-link"
                                                        href="/admin/orders?page=${pageNumber}">${pageNumber}</a>
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="page-item" aria-current="page">
                                                    <a class="page-link"
                                                        href="/admin/orders?page=${pageNumber}">${pageNumber}</a>
                                                </li>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                    <c:choose>
                                        <c:when test="${currentPage == totalPages}">
                                            <li class="page-item disabled">
                                                <a class="page-link" href="#"></a>
                                            </li>
                                        </c:when>
                                        <c:otherwise>
                                            <li class="page-item">
                                                <a class="page-link" href="/admin/orders?page=${currentPage+1}"
                                                    title="Sau">
                                                    <strong>&raquo;</strong>
                                                </a>
                                            </li>
                                        </c:otherwise>
                                    </c:choose>
                                </ul>
                            </nav>
                            <!-- / Content -->

                            <jsp:include page="../layout/footer.jsp" />
                        </div>
                        <!-- Content wrapper -->
                    </div>
                    <!-- / Layout page -->
                </div>

                <!-- Overlay -->
                <div class="layout-overlay layout-menu-toggle"></div>
            </div>

            <!-- Core JS -->
            <!-- build:js assets/vendor/js/core.js -->
            <script src="/admin/vendor/libs/jquery/jquery.js"></script>
            <script src="/admin/vendor/libs/popper/popper.js"></script>
            <script src="/admin/vendor/js/bootstrap.js"></script>
            <script src="/admin/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>

            <script src="/admin/vendor/js/menu.js"></script>
            <!-- endbuild -->

            <!-- Vendors JS -->
            <script src="/admin/vendor/libs/apex-charts/apexcharts.js"></script>

            <!-- Main JS -->
            <script src="/admin/js/main.js"></script>
            <script src="/admin/js/utils.js"></script>
            <!-- Page JS -->
            <script src="/admin/js/dashboards-analytics.js"></script>

            <!-- Place this tag in your head or just before your close body tag. -->
            <script async defer src="https://buttons.github.io/buttons.js"></script>
        </body>

        </html>