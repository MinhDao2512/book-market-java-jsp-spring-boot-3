<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@include file="/resources/taglib.jsp" %>
        <!DOCTYPE html>
        <html lang="en" class="light-style layout-menu-fixed" dir="ltr" data-theme="theme-default"
            data-assets-path="/admin/" data-template="vertical-menu-template-free">

        <head>
            <meta charset="utf-8" />
            <meta name="viewport"
                content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

            <title>StorySwap.vn | Bảng vai trò</title>

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
                                        <span class="text-muted fw-light">Quản Lý Người Dùng /</span> Vai Trò
                                    </h4>
                                </div>
                                <!-- Basic Bootstrap Table -->
                                <div class="card">
                                    <input type="hidden" data-roles-active="1" id="rolesActive" />
                                    <h5 class="card-header">BẢNG VAI TRÒ: </h5>
                                    <div class="table-responsive text-nowrap">
                                        <table class="table table-bordered table-striped">
                                            <thead>
                                                <tr>
                                                    <th class="text-center">ID</th>
                                                    <th class="text-center">Chức Danh</th>
                                                    <th class="text-center">Mô tả</th>
                                                    <th class="text-center">Ngày Khởi Tạo</th>
                                                    <th class="text-center">Tác Vụ</th>
                                                </tr>
                                            </thead>
                                            <tbody class="table-border-bottom-0">
                                                <c:forEach var="role" items="${roles}">
                                                    <tr>
                                                        <td class="col-md-1 text-center">
                                                            <strong>${role.id}</strong>
                                                        </td>
                                                        <td class="text-center">
                                                            ${role.name}
                                                        </td>
                                                        <td style="white-space: normal; word-wrap: break-word;">
                                                            ${role.description}
                                                        </td>
                                                        <td class="col-md-1">
                                                            <fmt:formatDate type="date" value="${role.createdAt}" />
                                                        </td>
                                                        <td class="col-md-1 text-center">
                                                            <a href="/admin/role/detail/${role.id}"
                                                                class="btn btn-outline-info" title="Xem chi tiết">
                                                                <i class="far fa-sticky-note"></i>
                                                                Xem
                                                            </a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
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
                                                <a class="page-link" href="/admin/roles?page=${currentPage-1}"
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
                                                        href="/admin/roles?page=${pageNumber}">${pageNumber}</a>
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="page-item" aria-current="page">
                                                    <a class="page-link"
                                                        href="/admin/roles?page=${pageNumber}">${pageNumber}</a>
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
                                                <a class="page-link" href="/admin/roles?page=${currentPage+1}"
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