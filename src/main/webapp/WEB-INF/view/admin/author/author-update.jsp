<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@include file="/resources/taglib.jsp" %>
        <!DOCTYPE html>
        <html lang="en" class="light-style layout-menu-fixed" dir="ltr" data-theme="theme-default"
            data-assets-path="/admin/" data-template="vertical-menu-template-free">

        <head>
            <meta charset="utf-8" />
            <meta name="viewport"
                content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

            <title>StorySwap.vn | Chi tiết tác giả</title>

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
                                <form:form id="formUpdateAuthor" modelAttribute="currentAuthor">
                                    <div class="d-flex justify-content-between">
                                        <h4 class="fw-bold py-3 mb-4">
                                            <span class="text-muted fw-light">Quản Lý Sách /</span>
                                            <span class="text-muted fw-light">Tác Giả /</span> id = ${currentAuthor.id}
                                        </h4>
                                    </div>
                                    <div class="row justify-content-center">
                                        <div class="col-xl-7">
                                            <!-- HTML5 Inputs -->
                                            <div class="card mb-4">
                                                <h5 class="card-header" style="color: goldenrod;">
                                                    <strong>Thông tin cá nhân</strong>
                                                </h5>
                                                <div class="card-body">
                                                    <div class="mb-3 row">
                                                        <label for="html5-url-input" class="col-md-2 col-form-label">Họ
                                                            và Tên:</label>
                                                        <div class="col-md-10">
                                                            <form:input class="form-control" type="text" id="name"
                                                                placeholder="Nguyen Minh Dao" name="name" path="name" />
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-date-input"
                                                            class="col-md-2 col-form-label">Ngày Sinh:</label>
                                                        <div class="col-md-3">
                                                            <form:input class="form-control" type="date" id="birthDate"
                                                                name="birthDate" path="birthDate" />
                                                        </div>
                                                        <label for="defaultSelect" class="col-md-2 col-form-label">Quốc
                                                            Tịch:</label>
                                                        <div class="col-md-5">
                                                            <form:input class="form-control" type="text"
                                                                id="nationality" placeholder="Viet Nam"
                                                                name="nationality" path="nationality" />
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-url-input"
                                                            class="col-md-2 col-form-label">Tiểu Sử :</label>
                                                        <div class="col-md-10">
                                                            <textarea class="form-control" name="biography"
                                                                id="biography" rows="5"
                                                                cols="100">${currentAuthor.biography}</textarea>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row justify-content-center mt-4">
                                        <div class="col-xl-7">
                                            <div class="d-flex justify-content-between">
                                                <a href="/admin/authors" class="btn btn-outline-secondary">Quay lại</a>
                                                <button id="btnUpdateAuthor" type="submit" class="btn btn-primary">Cập
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
                    $('#formUpdateAuthor').submit(function (e) {
                        e.preventDefault();
                        var form = document.getElementById('formUpdateAuthor');
                        var formData = new FormData(form);
                        var authorId = '${currentAuthor.id}';

                        sendAjaxRequest(formData, authorId);
                    });

                    // Call API using FormData
                    function sendAjaxRequest(formData, authorId) {
                        $.ajax({
                            type: 'PUT',
                            url: 'http://localhost:8082/api/admin/authors/' + authorId,
                            data: formData,
                            contentType: false,
                            processData: false,
                            success: function (response, textStatus, xhr) {
                                alert("Thành công! Bạn đã cập nhật tác giả có id = " + authorId);
                            },
                            error: function (xhr, status, error) {
                                alert('Lỗi khi cập nhật tác giả: ' + xhr.responseText);
                            }
                        });
                    }
                });
            </script>
        </body>

        </html>