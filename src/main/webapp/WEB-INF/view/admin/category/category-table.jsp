<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@include file="/resources/taglib.jsp" %>
        <!DOCTYPE html>
        <html lang="en" class="light-style layout-menu-fixed" dir="ltr" data-theme="theme-default"
            data-assets-path="/admin/" data-template="vertical-menu-template-free">

        <head>
            <meta charset="utf-8" />
            <meta name="viewport"
                content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

            <title>StorySwap.vn | Bảng thể loại</title>

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
                    <!--Start Alert Dialog-->
                    <div class="modal" tabindex="-1" id="exampleModal">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title">
                                        <strong>Thông báo</strong>
                                    </h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <p><strong>Bạn muốn xóa thể loại này ?</strong></p>
                                    <input id="categoryId" type="hidden" />
                                </div>
                                <div class="modal-footer">
                                    <button id="btnCancelDelete" class="btn btn-outline-secondary"
                                        data-bs-dismiss="modal">Hủy</button>
                                    <button id="btnConfirmDelete" class="btn btn-primary">Đồng ý</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--End Alert Dialog-->

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
                                        <span class="text-muted fw-light">Quản Lý Sách /</span> Thể Loại
                                    </h4>
                                    <h4 class="fw-bold py-3 mb-4">
                                        <a href="/admin/categories/create" class="btn btn-outline-primary"
                                            title="Tạo mới">
                                            <i class="far fa-plus-square"></i>
                                            Tạo
                                        </a>
                                    </h4>
                                </div>
                                <!-- Basic Bootstrap Table -->
                                <div class="card">
                                    <input type="hidden" data-categories-active="1" id="categoriesActive" />
                                    <h5 class="card-header">BẢNG THỂ LOẠI: </h5>
                                    <div class="table-responsive text-nowrap">
                                        <table class="table table-bordered table-striped">
                                            <thead>
                                                <tr>
                                                    <th class="text-center">ID</th>
                                                    <th class="text-center">Tên</th>
                                                    <th class="text-center">Mô Tả</th>
                                                    <th class="text-center">Ngày Khởi Tạo</th>
                                                    <th class="text-center">Tác Vụ</th>
                                                </tr>
                                            </thead>
                                            <tbody class="table-border-bottom-0">
                                                <c:forEach var="category" items="${categories}">
                                                    <tr data-category-id="${category.id}">
                                                        <td class="col-md-1 text-center">
                                                            <strong>${category.id}</strong>
                                                        </td>
                                                        <td class="text-center">
                                                            ${category.name}
                                                        </td>
                                                        <td>
                                                            ${category.description}
                                                        </td>
                                                        <td class="col-md-1">
                                                            ${category.createdAt}
                                                        </td>
                                                        <td class="col-md-2">
                                                            <a href="/admin/categories/detail/${category.id}"
                                                                class="btn btn-outline-info" title="Xem chi tiết">
                                                                <i class="far fa-sticky-note"></i>
                                                                Xem
                                                            </a>
                                                            <a href="/admin/categories/update/${category.id}"
                                                                class="btn btn-outline-warning" title="Cập nhật">
                                                                <i class="fas fa-pencil-alt"></i>
                                                                Sửa
                                                            </a>
                                                            <button data-bs-toggle="modal"
                                                                data-bs-target="#exampleModal" type="button"
                                                                class="btn btn-outline-danger btnDelete" title="Xóa"
                                                                data-category-id="${category.id}">
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
                                                <a class="page-link" href="/admin/categories?page=${currentPage-1}"
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
                                                        href="/admin/categories?page=${pageNumber}">${pageNumber}</a>
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="page-item" aria-current="page">
                                                    <a class="page-link"
                                                        href="/admin/categories?page=${pageNumber}">${pageNumber}</a>
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
                                                <a class="page-link" href="/admin/categories?page=${currentPage+1}"
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
            <script>
                $(document).ready(function (event) {

                    //Hidden Modal     
                    $(this).click(function () {
                        var btnDeletes = document.querySelectorAll('.btnDelete');
                        btnDeletes.forEach(function (button) {
                            button.blur();
                            button.classList.remove('active');
                        });
                    });

                    $(this).keydown(function () {
                        var btnDeletes = document.querySelectorAll('.btnDelete');
                        btnDeletes.forEach(function (button) {
                            button.blur();
                            button.classList.remove('active');
                        });
                    });

                    //Check event button delete on click
                    $('.btnDelete').click(function () {
                        var categoryId = $(this).data('category-id');
                        $('#categoryId').val(categoryId);
                    });

                    //Check event button confirm delete on click
                    $('#btnConfirmDelete').click(function () {
                        closeModalAndBackdrop();
                        var categoryId = $('#categoryId').val();
                        sendAJAXRequest(categoryId);
                    });

                    //Call API Delete 
                    function sendAJAXRequest(categoryId) {
                        $.ajax({
                            type: "DELETE",
                            url: "http://localhost:8082/api/admin/categories/" + categoryId,
                            success: function (response) {
                                $('tr[data-category-id="' + categoryId + '"]').remove();
                                alert("Bạn đã xóa thành công thể loại có ID = " + categoryId + "!");
                            },
                            error: function (jqXHR, status, error) {
                                alert("Thất bại! Bạn không thể xóa dữ liệu không còn tồn tại."
                                    + "\nChú ý: Trang sẽ được tải lại!" + jqXHR.responseText);
                                window.location.href = '/admin/categories';
                            }
                        });
                    }

                    function closeModalAndBackdrop() {
                        $('#exampleModal').modal('hide');
                        $('body').removeClass('modal-open');
                        $('.modal-backdrop').remove();
                    }
                });
            </script>
        </body>

        </html>