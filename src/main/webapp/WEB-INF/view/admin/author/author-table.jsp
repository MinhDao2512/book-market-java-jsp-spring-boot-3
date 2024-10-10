<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@include file="/resources/taglib.jsp" %>
        <!DOCTYPE html>
        <html lang="en" class="light-style layout-menu-fixed" dir="ltr" data-theme="theme-default"
            data-assets-path="/admin/" data-template="vertical-menu-template-free">

        <head>
            <meta charset="utf-8" />
            <meta name="viewport"
                content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

            <title>StorySwap.vn | Bảng tác giả</title>

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
                                        <span class="text-muted fw-light">Quản Lý Sách /</span> Tác Giả
                                    </h4>
                                    <h4 class="fw-bold py-3 mb-4">
                                        <a href="/admin/authors/create" class="btn btn-outline-primary" title="Tạo mới">
                                            <i class="far fa-plus-square"></i>
                                            Tạo
                                        </a>
                                    </h4>
                                </div>
                                <!-- Basic Bootstrap Table -->
                                <div class="card">
                                    <h5 class="card-header">BẢNG TÁC GIẢ:</h5>
                                    <div class="table-responsive text-nowrap">
                                        <table class="table table-bordered table-striped">
                                            <thead>
                                                <tr>
                                                    <th class="text-center">ID</th>
                                                    <th class="text-center">Tên</th>
                                                    <th class="text-center">Ngày Sinh</th>
                                                    <th class="text-center">Quốc Tịch</th>
                                                    <th class="text-center">Ngày Khởi Tạo</th>
                                                    <th class="text-center">Tác Vụ</th>
                                                </tr>
                                            </thead>
                                            <tbody class="table-border-bottom-0">
                                                <c:forEach var="author" items="${authors}">
                                                    <tr>
                                                        <td class="col-md-1 text-center">
                                                            <strong>${author.id}</strong>
                                                        </td>
                                                        <td class="text-center">
                                                            ${author.name}
                                                        </td>
                                                        <td class="col-md-1">
                                                            <fmt:formatDate type="date" value="${author.birthDate}" />
                                                        </td>
                                                        <td class="text-center">
                                                            <span class="badge bg-label-info me-1">
                                                                ${author.nationality}
                                                            </span>
                                                        </td>
                                                        <td class="col-md-1">
                                                            <fmt:formatDate type="date" value="${author.createdAt}" />
                                                        </td>
                                                        <td class="col-md-2">
                                                            <a href="#" class="btn btn-outline-info"
                                                                title="Xem chi tiết">
                                                                <i class="far fa-sticky-note"></i>
                                                                Xem
                                                            </a>
                                                            <a href="#" class="btn btn-outline-warning"
                                                                title="Cập nhật">
                                                                <i class="fas fa-pencil-alt"></i>
                                                                Sửa
                                                            </a>
                                                            <button data-bs-toggle="modal"
                                                                data-bs-target="#exampleModal" type="button"
                                                                class="btn btn-outline-danger btnDelete" title="Xóa">
                                                                <i class="fas fa-trash-alt"></i>
                                                                Xóa
                                                            </button>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <!--/ Basic Bootstrap Table -->
                            </div>
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

            <!-- Page JS -->
            <script src="/admin/js/dashboards-analytics.js"></script>

            <!-- Place this tag in your head or just before your close body tag. -->
            <script async defer src="https://buttons.github.io/buttons.js"></script>
        </body>

        </html>