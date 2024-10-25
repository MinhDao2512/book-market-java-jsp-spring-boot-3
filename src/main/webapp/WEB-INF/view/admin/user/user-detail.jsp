<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@include file="/resources/taglib.jsp" %>
        <!DOCTYPE html>
        <html lang="en" class="light-style layout-menu-fixed" dir="ltr" data-theme="theme-default"
            data-assets-path="/admin/" data-template="vertical-menu-template-free">

        <head>
            <meta charset="utf-8" />
            <meta name="viewport"
                content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

            <title>StorySwap.vn | Chi tiết người dùng</title>

            <meta name="description" content="" />

            <!-- Favicon -->
            <link rel="icon" type="image/x-icon" href="/admin/img/favicon/favicon.ico" />

            <!-- Fonts -->
            <link rel="preconnect" href="https://fonts.googleapis.com" />
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
            <link
                href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
                rel="stylesheet" />

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
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
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
                                <!--Start Form Create User-->
                                <form:form id="formCreateUser" modelAttribute="currentUser">
                                    <div class="d-flex justify-content-between">
                                        <h4 class="fw-bold py-3 mb-4">
                                            <span class="text-muted fw-light">Quản Lý Người Dùng /</span>
                                            <span class="text-muted fw-light">Người Dùng /</span> id = ${currentUser.id}
                                        </h4>
                                    </div>
                                    <div class="row justify-content-center">
                                        <div class="col-xl-3">
                                            <!-- File input -->
                                            <div class="card">
                                                <h5 class="card-header" style="color: goldenrod;">
                                                    <strong>Hình đại diện</strong>
                                                </h5>
                                                <div class="card-body d-flex justify-content-center align-items-center">
                                                    <div class="text-center">
                                                        <img src="/images/user/${currentUser.avatar}"
                                                            style="max-height: 200px; display: block; width: auto;"
                                                            alt="avatar preview" id="avatarPreview"
                                                            title="Avatar Preview " class="rounded-circle" />
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xl-7">
                                            <!-- HTML5 Inputs -->
                                            <div class="card mb-4">
                                                <h5 class="card-header" style="color: goldenrod;">
                                                    <strong>Thông tin cá nhân</strong>
                                                </h5>
                                                <div class="card-body">
                                                    <div class="mb-3 row">
                                                        <label for="html5-url-input" class="col-md-2 col-form-label">Họ
                                                            & Tên:</label>
                                                        <div class="col-md-10">
                                                            <form:input class="form-control" type="text" id="fulltName"
                                                                placeholder="Dao" name="fullName" path="fullName"
                                                                disabled="true" />
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-email-input"
                                                            class="col-md-2 col-form-label">Email:</label>
                                                        <div class="col-md-10">
                                                            <form:input class="form-control" type="email" id="email"
                                                                placeholder="vnkun@example.com" name="email"
                                                                path="email" disabled="true" />
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-tel-input" class="col-md-2 col-form-label">Tên
                                                            Tài Khoản:</label>
                                                        <div class="col-md-4">
                                                            <form:input class="form-control" type="tel" id="username"
                                                                placeholder="vnkun0602" name="username" path="username"
                                                                disabled="true" />
                                                        </div>
                                                        <label for="html5-tel-input" class="col-md-2 col-form-label">Số
                                                            Điện Thoại:</label>
                                                        <div class="col-md-4">
                                                            <form:input class="form-control" type="tel" id="phoneNumber"
                                                                placeholder="(+84)120 230 016" name="phoneNumber"
                                                                path="phoneNumber" disabled="true" />
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-url-input" class="col-md-2 col-form-label">Địa
                                                            Chỉ:</label>
                                                        <div class="col-md-10">
                                                            <form:input class="form-control" type="text" id="address"
                                                                placeholder="Số nhà, Phường, Quận, Thành phố "
                                                                name="address" path="address" disabled="true" />
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-date-input"
                                                            class="col-md-2 col-form-label">Ngày Sinh:</label>
                                                        <div class="col-md-3">
                                                            <form:input class="form-control" type="date"
                                                                id="dateOfBirth" name="dateOfBirth" path="dateOfBirth"
                                                                disabled="true" />
                                                        </div>
                                                        <label for="defaultSelect" class="col-md-2 col-form-label">Vai
                                                            Trò:</label>
                                                        <div class="col-md-5">
                                                            <form:input class="form-control" type="text" id="roleName"
                                                                name="roleName" path="role.name" disabled="true" />
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-date-input"
                                                            class="col-md-2 col-form-label">Ngày Khởi Tạo:</label>
                                                        <div class="col-md-3">
                                                            <form:input class="form-control" type="date" id="createdAt"
                                                                name="createdAt" path="createdAt" disabled="true" />
                                                        </div>
                                                        <label for="defaultSelect" class="col-md-2 col-form-label">Người
                                                            Khởi Tạo:</label>
                                                        <div class="col-md-5">
                                                            <form:input class="form-control" type="text" id="createdBy"
                                                                name="createdBy" path="createdBy" disabled="true"
                                                                placeholder="ngminhdao" />
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-date-input"
                                                            class="col-md-2 col-form-label">Ngày Cập Nhật:</label>
                                                        <div class="col-md-3">
                                                            <form:input class="form-control" type="date" id="updatedAt"
                                                                name="updatedAt" path="updatedAt" disabled="true" />
                                                        </div>
                                                        <label for="defaultSelect" class="col-md-2 col-form-label">Người
                                                            Cập Nhật:</label>
                                                        <div class="col-md-5">
                                                            <form:input class="form-control" type="text" id="updatedBy"
                                                                name="updatedBy" path="updatedBy" disabled="true"
                                                                placeholder="ngminhdao" />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row justify-content-center mt-4">
                                        <div class="col-xl-10">
                                            <div class="d-flex justify-content-between">
                                                <a href="/admin/users" class="btn btn-outline-secondary">Quay lại</a>
                                            </div>
                                        </div>
                                    </div>
                                </form:form>
                                <!--End Form Create User-->
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