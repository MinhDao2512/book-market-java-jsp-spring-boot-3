<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@include file="/resources/taglib.jsp" %>
        <!DOCTYPE html>
        <html lang="en" class="light-style layout-menu-fixed" dir="ltr" data-theme="theme-default"
            data-assets-path="/admin/" data-template="vertical-menu-template-free">

        <head>
            <meta charset="utf-8" />
            <meta name="viewport"
                content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

            <title>StorySwap.vn | Thêm mới sách </title>

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
                                <form id="formCreateBook" novalidate>
                                    <div class="d-flex justify-content-between">
                                        <h4 class="fw-bold py-3 mb-4">
                                            <span class="text-muted fw-light">Quản Lý Sách /</span>
                                            <span class="text-muted fw-light">Sách /</span> Tạo mới
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
                                                            <input class="form-control" type="text" id="ISBN"
                                                                placeholder="9786042272971" name="ISBN" required />
                                                            <div class="invalid-feedback">
                                                                Bạn chưa nhập "ISBN"
                                                            </div>
                                                        </div>
                                                        <label for="html5-email-input"
                                                            class="col-md-2 col-form-label">Ngày xuất bản:</label>
                                                        <div class="col-md-4">
                                                            <input class="form-control" type="date" id="publicationDate"
                                                                name="publicationDate" required />
                                                            <div class="invalid-feedback">
                                                                Bạn chưa nhập "Ngày Xuất Bản"
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-url-input"
                                                            class="col-md-2 col-form-label">Tiêu đề:</label>
                                                        <div class="col-md-10">
                                                            <input class="form-control" type="text" id="title"
                                                                placeholder="Clean Code" name="title" required />
                                                            <div class="invalid-feedback">
                                                                Bạn chưa nhập "Tiêu Đề"
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-date-input"
                                                            class="col-md-2 col-form-label">Thể loại:</label>
                                                        <div class="col-md-10">
                                                            <select id="categories" class="form-select"
                                                                name="categories" multiple size="5" required>
                                                                <c:forEach var="category" items="${categories}">
                                                                    <option value="${category.name}">
                                                                        ${category.description}
                                                                    </option>
                                                                </c:forEach>
                                                            </select>
                                                            <div class="invalid-feedback">
                                                                Bạn chưa chọn "Thể Loại"
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-date-input" class="col-md-2 col-form-label">Số
                                                            lượng:</label>
                                                        <div class="col-md-4">
                                                            <div class="input-group">
                                                                <span class="input-group-text">quyển</span>
                                                                <input class="form-control" type="text" id="quantity"
                                                                    name="quantity" required />
                                                                <div class="invalid-feedback">
                                                                    Bạn chưa nhập "Số Lượng"
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <label for="html5-date-input"
                                                            class="col-md-2 col-form-label">Giá Bán:</label>
                                                        <div class="col-md-4">
                                                            <div class="input-group">
                                                                <span class="input-group-text">vnđ</span>
                                                                <input class="form-control" type="text" id="price"
                                                                    name="price" required />
                                                                <div class="invalid-feedback">
                                                                    Bạn chưa nhập "Giá Bán"
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-date-input"
                                                            class="col-md-2 col-form-label">Tình trạng:</label>
                                                        <div class="col-md-4">
                                                            <select id="state" class="form-select" name="state"
                                                                required>
                                                                <option selected value="">Chọn tình trạng</option>
                                                                <option value="NEW">Mới</option>
                                                                <option value="LIKE NEW">Mới 98%</option>
                                                                <option value="USED">Đã sử dụng</option>
                                                            </select>
                                                            <div class="invalid-feedback">
                                                                Bạn chưa chọn "Tình Trạng"
                                                            </div>
                                                        </div>
                                                        <label for="html5-date-input"
                                                            class="col-md-2 col-form-label">Công ty phát hành :</label>
                                                        <div class="col-md-4">
                                                            <input class="form-control" type="text"
                                                                id="publishingCompany" name="publishingCompany"
                                                                placeholder="Nhã Nam" required />
                                                            <div class="invalid-feedback">
                                                                Bạn chưa nhập tên "Công Ty Phát Hành"
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-date-input"
                                                            class="col-md-2 col-form-label">Kích thước:</label>
                                                        <div class="col-md-4">
                                                            <input class="form-control" type="text" id="size"
                                                                name="size" required
                                                                placeholder="rộng x dài cm | inch" />
                                                            <div class="invalid-feedback">
                                                                Bạn chưa nhập "Kích Thước"
                                                            </div>
                                                        </div>
                                                        <label for="html5-date-input"
                                                            class="col-md-2 col-form-label">Dịch giả:</label>
                                                        <div class="col-md-4">
                                                            <input class="form-control" type="text" id="translator"
                                                                name="translator" required />
                                                            <div class="invalid-feedback">
                                                                Bạn chưa nhập tên "Dịch Giả"
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-date-input"
                                                            class="col-md-2 col-form-label">Loại bìa:</label>
                                                        <div class="col-md-4">
                                                            <select id="coverType" class="form-select" name="coverType"
                                                                required>
                                                                <option selected value="">Chọn loại bìa</option>
                                                                <option value="BIA CUNG">Bìa cứng</option>
                                                                <option value="BIA MEM">Bìa mềm</option>
                                                                <option value="BIA XOAN OC">Bìa xoắn ốc</option>
                                                            </select>
                                                            <div class="invalid-feedback">
                                                                Bạn chưa chọn "Loại Bìa"
                                                            </div>
                                                        </div>
                                                        <label for="html5-date-input" class="col-md-2 col-form-label">Số
                                                            trang:</label>
                                                        <div class="col-md-4">
                                                            <div class="input-group">
                                                                <span class="input-group-text">trang</span>
                                                                <input class="form-control" type="text"
                                                                    id="numberOfPages" name="numberOfPages" required />
                                                                <div class="invalid-feedback">
                                                                    Bạn chưa nhập "Số Trang"
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-date-input" class="col-md-2 col-form-label">Mô
                                                            tả sản phẩm:</label>
                                                        <div class="col-md-10">
                                                            <textarea class="form-control" id="description"
                                                                name="description" rows="10" cols="50"
                                                                required></textarea>
                                                            <div class="invalid-feedback">
                                                                Bạn chưa nhập "Mô Tả Sản Phẩm"
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-date-input"
                                                            class="col-md-2 col-form-label">Tác giả:</label>
                                                        <div class="col-md-10">
                                                            <select id="selectAuthor" class="form-select"
                                                                name="authorDefault" required>
                                                                <!-- <option selected>Chọn tác giả</option> -->
                                                                <option selected value="">Chọn tác giả</option>
                                                                <c:forEach var="author" items="${authors}">
                                                                    <option value="${author.name}">
                                                                        ${author.name}
                                                                    </option>
                                                                </c:forEach>
                                                                <option value="OTHER">Lựa chọn khác (Other)</option>
                                                            </select>
                                                            <div class="invalid-feedback">
                                                                Bạn chưa chọn "Tác Giả"
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-date-input"
                                                            class="col-md-2 col-form-label">Nhà xuất bản:</label>
                                                        <div class="col-md-10">
                                                            <select id="selectPublisher" class="form-select"
                                                                name="publisher" required>
                                                                <!-- <option selected>Chọn tác giả</option> -->
                                                                <option selected value="">Chọn nhà xuất bản</option>
                                                                <c:forEach var="publisher" items="${publishers}">
                                                                    <option value="${publisher.name}">
                                                                        Nhà Xuất Bản ${publisher.name}
                                                                    </option>
                                                                </c:forEach>
                                                            </select>
                                                            <div class="invalid-feedback">
                                                                Bạn chưa chọn "Nhà Xuất Bản"
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <!-- Author New -->
                                            <div class="card mb-4 other-author" style="display: none;">
                                                <h5 class="card-header" style="color: goldenrod;">
                                                    <strong>Sách | Tác giả khác (Other)</strong>
                                                </h5>
                                                <div class="card-body">
                                                    <div class="mb-3 row">
                                                        <label for="html5-url-input" class="col-md-2 col-form-label">Họ
                                                            Và Tên:</label>
                                                        <div class="col-md-10">
                                                            <input class="form-control" type="text" id="authorName"
                                                                placeholder="Alex Nguyen" name="newAuthor.name" />
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-email-input"
                                                            class="col-md-2 col-form-label">Ngày Sinh:</label>
                                                        <div class="col-md-4">
                                                            <input class="form-control" type="date" id="birthDate"
                                                                name="newAuthor.birthDate" />
                                                        </div>
                                                        <label for="html5-url-input"
                                                            class="col-md-2 col-form-label">Quốc Tịch:</label>
                                                        <div class="col-md-4">
                                                            <input class="form-control" type="text" id="nationality"
                                                                placeholder="Viet Nam" name="newAuthor.nationality" />
                                                        </div>
                                                    </div>
                                                    <div class="mb-3 row">
                                                        <label for="html5-date-input"
                                                            class="col-md-2 col-form-label">Tiểu Sử:</label>
                                                        <div class="col-md-10">
                                                            <textarea class="form-control" id="biography"
                                                                name="newAuthor.biography" rows="5"
                                                                cols="50"></textarea>
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
                                                            type="file" id="bookFiles" name="bookFiles" multiple
                                                            required />
                                                        <div class="invalid-feedback">
                                                            Bạn chưa chọn "Hình Mô Tả"
                                                        </div>
                                                    </div>
                                                    <div class="mb-3" id="imagePreviewContainer">
                                                        <!--Preview Images-->
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row justify-content-center mt-4">
                                        <div class="col-xl-7">
                                            <div class="d-flex justify-content-between">
                                                <a href="/admin/books" class="btn btn-outline-secondary">Quay lại</a>
                                                <button id="btnCreateBook" type="submit" class="btn btn-primary">Thêm
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

            <!-- Page JS -->
            <script src="/admin/js/dashboards-analytics.js"></script>

            <!-- Place this tag in your head or just before your close body tag. -->
            <script async defer src="https://buttons.github.io/buttons.js"></script>
            <script src="/admin/js/validation/book.js"></script>
        </body>

        </html>