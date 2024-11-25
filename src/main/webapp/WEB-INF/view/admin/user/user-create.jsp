<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@include file="/resources/taglib.jsp" %>
        <!DOCTYPE html>
        <html lang="en" class="light-style layout-menu-fixed" dir="ltr" data-theme="theme-default"
            data-assets-path="/admin/" data-template="vertical-menu-template-free">

        <head>
            <meta charset="utf-8" />
            <meta name="viewport"
                content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

            <title>StorySwap.vn | Thêm mới người dùng</title>

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
                                <form id="formCreateUser" novalidate>
                                    <div class="d-flex justify-content-between">
                                        <input type="hidden" data-users-active="1" id="usersActive" />
                                        <h4 class="fw-bold py-3 mb-4">
                                            <span class="text-muted fw-light">Quản Lý Người Dùng /</span>
                                            <span class="text-muted fw-light">Người Dùng /</span> Tạo mới
                                        </h4>
                                    </div>

                                    <!--Info User-->
                                    <div class="row justify-content-center">
                                        <div class="col-xl-3">
                                            <!-- File input -->
                                            <div class="card">
                                                <h5 class="card-header" style="color: goldenrod;">
                                                    <strong>Hình đại diện</strong>
                                                </h5>
                                                <div class="card-body">
                                                    <div class="mb-3">
                                                        <input class="form-control" accept=".png, .jpg, .jpeg"
                                                            type="file" id="avatarFile" name="avatarFile" />
                                                    </div>
                                                    <div class="text-center">
                                                        <img style="max-height: 200px; display: none; width: auto;"
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
                                                        <label for="html5-url-input" class="col-md-2 col-form-label">
                                                            Tên: <strong style="color: red;">*</strong>
                                                        </label>
                                                        <div class="col-md-3">
                                                            <input class="form-control" type="text" id="firstName"
                                                                placeholder="Dao" name="firstName" required />
                                                            <div class="invalid-feedback">
                                                                Bạn chưa nhập "Tên"
                                                            </div>
                                                        </div>
                                                        <label for="html5-url-input" class="col-md-2 col-form-label">Họ
                                                            & Tên Đệm: <strong style="color: red;">*</strong></label>
                                                        <div class="col-md-5">
                                                            <input class="form-control" type="text" id="lastName"
                                                                placeholder="Nguyen Minh" name="lastName" required />
                                                            <div class="invalid-feedback">
                                                                Bạn chưa nhập "Họ và Tên Đệm"
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-email-input"
                                                            class="col-md-2 col-form-label">Email: <strong
                                                                style="color: red;">*</strong></label>
                                                        <div class="col-md-10">
                                                            <input class="form-control" type="text" id="email"
                                                                placeholder="vnkun@example.com" name="email" required />
                                                            <div class="invalid-feedback">
                                                                Bạn chưa nhập "Email"
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-password-input"
                                                            class="col-md-2 col-form-label">Mật Khẩu: <strong
                                                                style="color: red;">*</strong></label>
                                                        <div class="col-md-4">
                                                            <input class="form-control" type="password" id="password"
                                                                name="password" placeholder="********" required />
                                                            <div class="invalid-feedback">
                                                                Bạn chưa nhập "Mật Khẩu"
                                                            </div>
                                                        </div>
                                                        <label for="html5-password-input"
                                                            class="col-md-2 col-form-label">Xác Nhận Mật Khẩu: <strong
                                                                style="color: red;">*</strong></label>
                                                        <div class="col-md-4">
                                                            <input class="form-control" type="password"
                                                                id="confirmPassword" name="confirmPassword"
                                                                placeholder="********" required />
                                                            <div class="invalid-feedback">
                                                                Bạn chưa nhập "Xác Nhận Mật Khẩu"
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-tel-input" class="col-md-2 col-form-label">Số
                                                            Điện Thoại: <strong style="color: red;">*</strong></label>
                                                        <div class="col-md-10">
                                                            <input class="form-control" type="tel" id="phoneNumber"
                                                                placeholder="+84 120 230 016" name="phoneNumber"
                                                                required />
                                                            <div class="invalid-feedback">
                                                                Bạn chưa nhập "Số Điện Thoại"
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-date-input"
                                                            class="col-md-2 col-form-label">Ngày Sinh: <strong
                                                                style="color: red;">*</strong></label>
                                                        <div class="col-md-3">
                                                            <input class="form-control" type="date" id="dateOfBirth"
                                                                name="dateOfBirth" required />
                                                            <div class="invalid-feedback">
                                                                Bạn chưa nhập "Ngày Sinh"
                                                            </div>
                                                        </div>
                                                        <label for="defaultSelect" class="col-md-2 col-form-label">Vai
                                                            Trò: <strong style="color: red;">*</strong></label>
                                                        <div class="col-md-5">
                                                            <select id="selectRole" class="form-select" name="roleName"
                                                                required>
                                                                <option value="" selected>Chọn vai trò</option>
                                                                <c:forEach var="role" items="${roles}">
                                                                    <option value="${role.name}">
                                                                        ${role.name}
                                                                    </option>
                                                                </c:forEach>
                                                            </select>
                                                            <div class="invalid-feedback">
                                                                Bạn chưa chọn "Vai Trò"
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <!--Address Input-->
                                    <div class="row justify-content-center">
                                        <div class="col-xl-3"></div>
                                        <div class="col-xl-7">
                                            <!-- HTML5 Inputs -->
                                            <div class="card mb-4">
                                                <h5 class="card-header" style="color: goldenrod;">
                                                    <strong>Địa chỉ hiện tại</strong>
                                                </h5>
                                                <div class="card-body">
                                                    <div class="mb-3 row">
                                                        <label for="html5-url-input" class="col-md-2 col-form-label">Số
                                                            Nhà:</label>
                                                        <div class="col-md-3">
                                                            <input class="form-control" type="text" id="houseNumber"
                                                                placeholder="D21/3" name="houseNumber" />
                                                        </div>
                                                        <label for="html5-url-input" class="col-md-2 col-form-label">Tên
                                                            Đường | Thôn: <strong style="color: red;">*</strong></label>
                                                        <div class="col-md-5">
                                                            <input class="form-control" type="text" id="street"
                                                                placeholder="Trần Não" name="street" required />
                                                            <div class="invalid-feedback">
                                                                Bạn chưa nhập "Tên Đường | Thôn"
                                                            </div>
                                                        </div>
                                                    </div>

                                                    <div class="mb-3 row">
                                                        <label for="html5-url-input" class="col-md-2 col-form-label">Tên
                                                            Phường | Xã: <strong style="color: red;">*</strong></label>
                                                        <div class="col-md-4">
                                                            <input class="form-control" type="text" id="ward"
                                                                placeholder="An Khánh" name="ward" required />
                                                            <div class="invalid-feedback">
                                                                Bạn chưa nhập "Tên Phường | Xã"
                                                            </div>
                                                        </div>
                                                        <label for="html5-url-input" class="col-md-2 col-form-label">Tên
                                                            Quận | Huyện: <strong style="color: red;">*</strong></label>
                                                        <div class="col-md-4">
                                                            <input class="form-control" type="text" id="district"
                                                                placeholder="Tp. Thủ Đức" name="district" required />
                                                            <div class="invalid-feedback">
                                                                Bạn chưa nhập "Tên Quận | Huyện"
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-password-input"
                                                            class="col-md-2 col-form-label">Tên Tỉnh | Thành
                                                            Phố: <strong style="color: red;">*</strong></label>
                                                        <div class="col-md-4">
                                                            <input class="form-control" type="text" id="city"
                                                                name="city" placeholder="Hồ Chí Minh" required />
                                                            <div class="invalid-feedback">
                                                                Bạn chưa nhập "Tên Tỉnh | Thành Phố"
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <!--Action Button-->
                                    <div class="row justify-content-center mt-4">
                                        <div class="col-xl-3"></div>
                                        <div class="col-xl-7">
                                            <div class="d-flex justify-content-between">
                                                <a href="/admin/users?page=1" class="btn btn-outline-secondary">Quay
                                                    lại</a>
                                                <button id="btnCreateUser" type="submit" class="btn btn-primary">Thêm
                                                    mới</button>
                                            </div>
                                        </div>
                                    </div>
                                </form>
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
            <script src="/admin/js/utils.js"></script>
            <!-- Page JS -->
            <script src="/admin/js/dashboards-analytics.js"></script>

            <!-- Place this tag in your head or just before your close body tag. -->
            <script async defer src="https://buttons.github.io/buttons.js"></script>
            <script src="/admin/js/validation/user/user-create.js"></script>
        </body>

        </html>