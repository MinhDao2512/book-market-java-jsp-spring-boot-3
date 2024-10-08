<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@include file="/resources/taglib.jsp" %>
        <!DOCTYPE html>
        <html lang="en" class="light-style layout-menu-fixed" dir="ltr" data-theme="theme-default"
            data-assets-path="/admin/" data-template="vertical-menu-template-free">

        <head>
            <meta charset="utf-8" />
            <meta name="viewport"
                content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

            <title>StorySwap.vn | Cập nhật người dùng</title>

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
                                <form:form id="formUpdateUser" modelAttribute="currentUser">
                                    <div class="d-flex justify-content-between">
                                        <h4 class="fw-bold py-3 mb-4">
                                            <span class="text-muted fw-light">Quản Lý Người Dùng /</span>
                                            <span class="text-muted fw-light">Người Dùng /</span> id = ${currentUser.id}
                                        </h4>
                                    </div>
                                    <div class="row justify-content-center">
                                        <div class="col-xl-3">
                                            <div class="card">
                                                <h5 class="card-header" style="color: goldenrod;">
                                                    <strong>Hình đại diện</strong>
                                                </h5>
                                                <div class="card-body">
                                                    <div class="mb-3">
                                                        <input class="form-control" accept=".png, .jpg, .jpeg"
                                                            type="file" id="avatarFile" name="avatarFile" />
                                                    </div>
                                                    <div class="mb-3">
                                                        <img style="max-height: 200px; display: block;"
                                                            alt="avatar preview" id="avatarPreview"
                                                            src="/images/user/${currentUser.avatar}"
                                                            class="rounded-circle" title="Avatar Preview " />
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
                                                        <label for="html5-url-input"
                                                            class="col-md-2 col-form-label">Full Name:</label>
                                                        <div class="col-md-10">
                                                            <form:input class="form-control" type="text" id="fullName"
                                                                placeholder="Nguyen Minh Dao" name="fullName"
                                                                path="fullName" />
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-email-input"
                                                            class="col-md-2 col-form-label">Email:</label>
                                                        <div class="col-md-10">
                                                            <form:input class="form-control" type="email" id="email"
                                                                placeholder="vnkun@example.com" name="email"
                                                                disabled="true" path="email" />
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-tel-input"
                                                            class="col-md-2 col-form-label">Username:</label>
                                                        <div class="col-md-4">
                                                            <form:input class="form-control" type="text" id="username"
                                                                placeholder="vnkunn" name="username" disabled="true"
                                                                path="username" />
                                                        </div>
                                                        <label for="html5-tel-input"
                                                            class="col-md-2 col-form-label">Phone:</label>
                                                        <div class="col-md-4">
                                                            <form:input class="form-control" type="tel" id="phoneNumber"
                                                                placeholder="(+84)120 230 016" name="phoneNumber"
                                                                path="phoneNumber" />
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-url-input"
                                                            class="col-md-2 col-form-label">Address:</label>
                                                        <div class="col-md-10">
                                                            <form:input class="form-control" type="text" id="address"
                                                                placeholder="Số nhà, Phường, Quận, Thành phố "
                                                                name="address" path="address" />
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-date-input"
                                                            class="col-md-2 col-form-label">Date:</label>
                                                        <div class="col-md-3">
                                                            <form:input class="form-control" type="date"
                                                                id="dateOfBirth" name="dateOfBirth"
                                                                path="dateOfBirth" />
                                                        </div>
                                                        <label for="defaultSelect"
                                                            class="col-md-2 col-form-label">Role:</label>
                                                        <div class="col-md-5">
                                                            <form:select id="selectRole" class="form-select"
                                                                name="role.name" path="role.name">
                                                                <form:option value="USER">User</form:option>
                                                                <form:option value="CONTENT">Content</form:option>
                                                                <form:option value="ADMIN">Admin</form:option>
                                                            </form:select>
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-date-input"
                                                            class="col-md-2 col-form-label">Created At:</label>
                                                        <div class="col-md-3">
                                                            <form:input class="form-control" type="date" id="createdAt"
                                                                name="createdAt" disabled="true" path="createdAt" />
                                                        </div>
                                                        <label for="defaultSelect"
                                                            class="col-md-2 col-form-label">Created By:</label>
                                                        <div class="col-md-5">
                                                            <form:input class="form-control" type="text" id="createdBy"
                                                                name="createdBy" disabled="true" path="createdBy"
                                                                placeholder="ngminhdao" />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row justify-content-center mt-4">
                                        <div class="col-xl-3"></div>
                                        <div class="col-xl-7">
                                            <div class="d-flex justify-content-between">
                                                <a href="/admin/users" class="btn btn-outline-secondary">Quay lại</a>
                                                <button id="btnUpdateUser" type="submit" class="btn btn-primary">Cập
                                                    nhật</button>
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
            <script>
                $(document).ready(() => {
                    //Form Submit
                    $('#formUpdateUser').submit(function (event) {
                        event.preventDefault();
                        var form = document.getElementById('formUpdateUser');
                        var formData = new FormData(form);
                        var userId = '${currentUser.id}';

                        sendAjaxRequest(userId, formData);
                    });

                    // Call API using FormData
                    function sendAjaxRequest(userId, formData) {
                        $.ajax({
                            type: 'PUT',
                            url: 'http://localhost:8082/api/admin/users/' + userId,
                            data: formData,
                            contentType: false,
                            processData: false,
                            success: function (response) {
                                alert('Bạn đã cập nhật người dùng thành công!');
                            },
                            error: function (xhr, status, error) {
                                alert('Lỗi khi cập nhật người dùng: ' + xhr.responseText);
                            }
                        });
                    }

                    // Preview Avatar
                    const avatarFile = $("#avatarFile");
                    avatarFile.change(
                        function (e) {
                            const imfURL = URL.createObjectURL(e.target.files[0]);
                            $("#avatarPreview").attr("src", imfURL);
                            $("#avatarPreview").css({ "display": "block" });
                        }
                    );
                });
            </script>
        </body>

        </html>