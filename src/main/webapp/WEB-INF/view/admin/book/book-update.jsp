<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@include file="/resources/taglib.jsp" %>
        <!DOCTYPE html>
        <html lang="en" class="light-style layout-menu-fixed" dir="ltr" data-theme="theme-default"
            data-assets-path="/admin/" data-template="vertical-menu-template-free">

        <head>
            <meta charset="utf-8" />
            <meta name="viewport"
                content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

            <title>StorySwap.vn | Cập nhật sách</title>

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
                                <form:form id="formCreateBook" modelAttribute="currentBook">
                                    <div class="d-flex justify-content-between">
                                        <h4 class="fw-bold py-3 mb-4">
                                            <span class="text-muted fw-light">Quản Lý Sách /</span>
                                            <span class="text-muted fw-light">Sách /</span> id = ${currentBook.id}
                                        </h4>
                                    </div>
                                    <div class="row justify-content-center">
                                        <div class="col-xl-7">
                                            <!-- HTML5 Inputs -->
                                            <div class="card mb-4">
                                                <h5 class="card-header" style="color: goldenrod;">
                                                    <strong>Sách | Thông tin</strong>
                                                </h5>
                                                <div class="card-body">
                                                    <div class="mb-3 row">
                                                        <label for="html5-email-input"
                                                            class="col-md-2 col-form-label">ISBN:</label>
                                                        <div class="col-md-4">
                                                            <form:input class="form-control" type="text" id="ISBN"
                                                                name="ISBN" path="ISBN" />
                                                        </div>
                                                        <label for="html5-email-input"
                                                            class="col-md-2 col-form-label">Ngày xuất bản:</label>
                                                        <div class="col-md-4">
                                                            <form:input class="form-control" type="date"
                                                                id="publicationDate" name="publicationDate"
                                                                path="publicationDate" />
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-url-input"
                                                            class="col-md-2 col-form-label">Tiêu đề:</label>
                                                        <div class="col-md-10">
                                                            <form:input class="form-control" type="text" id="title"
                                                                placeholder="Clean Code" name="title" path="title" />
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-date-input"
                                                            class="col-md-2 col-form-label">Thể loại:</label>
                                                        <div class="col-md-10">
                                                            <select id="categories" class="form-select"
                                                                name="categories" multiple size="3" disabled="true">
                                                                <c:forEach var="bookCate"
                                                                    items="${currentBook.bookCategorizations}">
                                                                    <option value="${bookCate.category.name}">
                                                                        ${bookCate.category.description}
                                                                    </option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-date-input" class="col-md-2 col-form-label">Số
                                                            lượng:</label>
                                                        <div class="col-md-4">
                                                            <div class="input-group">
                                                                <form:input class="form-control" type="text"
                                                                    id="quantity" name="quantity" path="quantity" />
                                                                <span class="input-group-text">quyển</span>
                                                            </div>
                                                        </div>
                                                        <label for="html5-date-input"
                                                            class="col-md-2 col-form-label">Giá bán:</label>
                                                        <div class="col-md-4">
                                                            <div class="input-group">
                                                                <form:input class="form-control" type="text" id="price"
                                                                    name="price" path="price" />
                                                                <span class="input-group-text">vnd</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-date-input"
                                                            class="col-md-2 col-form-label">Tình trạng:</label>
                                                        <div class="col-md-4">
                                                            <form:select id="state" class="form-select" name="state"
                                                                path="state">
                                                                <form:option value="NEW">New</form:option>
                                                                <form:option value="LIKE NEW">Like New</form:option>
                                                                <form:option value="USED">Used</form:option>
                                                            </form:select>
                                                        </div>
                                                        <label for="html5-date-input"
                                                            class="col-md-2 col-form-label">Công ty phát hành :</label>
                                                        <div class="col-md-4">
                                                            <form:input class="form-control" type="text"
                                                                id="publishingCompany" name="publishingCompany"
                                                                path="publishingCompany" />
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-date-input"
                                                            class="col-md-2 col-form-label">Kích thước:</label>
                                                        <div class="col-md-4">
                                                            <div class="input-group">
                                                                <form:input class="form-control" type="text" id="size"
                                                                    name="size" path="size" />
                                                                <span class="input-group-text">cm</span>
                                                            </div>
                                                        </div>
                                                        <label for="html5-date-input"
                                                            class="col-md-2 col-form-label">Dịch giả:</label>
                                                        <div class="col-md-4">
                                                            <form:input class="form-control" type="text" id="translator"
                                                                name="translator" path="translator" />
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-date-input"
                                                            class="col-md-2 col-form-label">Loại bìa:</label>
                                                        <div class="col-md-4">
                                                            <form:select id="coverType" class="form-select"
                                                                name="coverType" path="coverType">
                                                                <form:option value="BIA CUNG">Bìa cứng</form:option>
                                                                <form:option value="BIA MEM">Bìa mềm</form:option>
                                                                <form:option value="BIA XOAN OC">Bìa xoắn ốc
                                                                </form:option>
                                                            </form:select>
                                                        </div>
                                                        <label for="html5-date-input" class="col-md-2 col-form-label">Số
                                                            trang:</label>
                                                        <div class="col-md-4">
                                                            <div class="input-group">
                                                                <form:input class="form-control" type="text"
                                                                    id="numberOfPages" name="numberOfPages"
                                                                    path="numberOfPages" />
                                                                <span class="input-group-text">trang</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-date-input" class="col-md-2 col-form-label">Mô
                                                            tả sản phẩm:</label>
                                                        <div class="col-md-10">
                                                            <textarea class="form-control" id="description"
                                                                name="description" rows="10"
                                                                cols="50">${currentBook.description}</textarea>
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-date-input"
                                                            class="col-md-2 col-form-label">Tác giả:</label>
                                                        <div class="col-md-10">
                                                            <form:input class="form-control" type="text"
                                                                id="author.name" name="author.name" path="author.name"
                                                                disabled="true" />
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-date-input"
                                                            class="col-md-2 col-form-label">Nhà xuất bản:</label>
                                                        <div class="col-md-10">
                                                            <form:input class="form-control" type="text" id="publisher"
                                                                name="publisher" path="publisher.name"
                                                                disabled="true" />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <!-- File input -->
                                            <div class="card">
                                                <h5 class="card-header" style="color: goldenrod;">
                                                    <strong>Sách | Hình mô tả</strong>
                                                </h5>
                                                <div class="card-body">
                                                    <div class="mb-3">
                                                        <input class="form-control" accept=".png, .jpg, .jpeg"
                                                            type="file" id="bookFiles" name="bookFiles" multiple />
                                                    </div>
                                                    <div class="mb-3" id="imagePreviewContainer">
                                                        <!--Preview Images-->
                                                        <c:forEach var="file" items="${currentBook.bookImages}">
                                                            <img src="/images/book/${file.name}" alt="Avatar Preview"
                                                                style="max-height: 200px; margin: 10px;" />
                                                        </c:forEach>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row justify-content-center mt-4">
                                        <div class="col-xl-7">
                                            <div class="d-flex justify-content-between">
                                                <a href="/admin/books" class="btn btn-outline-secondary">Quay lại</a>
                                                <button id="btnCreateBook" type="submit" class="btn btn-primary">Cập
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
                $(document).ready(function (event) {
                    $('#formCreateBook').submit(function (event) {
                        event.preventDefault();
                        var form = document.getElementById('formCreateBook');
                        var formData = new FormData(form);
                        var id = '${currentBook.id}';
                        sendAjaxRequest(formData, id);
                    });

                    function sendAjaxRequest(formData, id) {
                        $.ajax({
                            type: 'PUT',
                            url: 'http://localhost:8082/api/admin/books/' + id,
                            data: formData,
                            contentType: false,
                            processData: false,
                            success: function (response) {
                                alert('Bạn đã cập nhật sản phẩm thành công!');
                            },
                            error: function (xhr, status, error) {
                                alert('Lỗi khi cập nhật sản phẩm: ' + xhr.responseText);
                            }
                        });
                    }

                    // Preview Avatar
                    $('#bookFiles').change(
                        function (e) {
                            const previewContainer = $("#imagePreviewContainer");
                            previewContainer.html("");

                            [...e.target.files].forEach((file, index) => {
                                const imgURL = URL.createObjectURL(file);
                                $('<img>', {
                                    src: imgURL,
                                    alt: "Avatar Preview",
                                    title: `Avatar Preview ${index + 1}`,
                                    css: { maxHeight: '200px', margin: '10px' }
                                }).appendTo(previewContainer);
                            });
                        }
                    );
                });
            </script>
        </body>

        </html>