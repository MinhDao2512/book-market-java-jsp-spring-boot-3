<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@include file="/resources/taglib.jsp" %>
    <!DOCTYPE html>
    <html lang="en" class="light-style layout-menu-fixed" dir="ltr" data-theme="theme-default"
      data-assets-path="/admin/" data-template="vertical-menu-template-free">

    <head>
      <meta charset="utf-8" />
      <meta name="viewport"
        content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

      <title>StorySwap.vn | Thống kê</title>

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
                <div class="row">
                  <div class="col-lg-6 col-md-6 order-1">
                    <div class="row">
                      <div class="col-lg-6 col-md-12 col-6 mb-4">
                        <div class="card">
                          <div class="card-body">
                            <div class="card-title d-flex align-items-start justify-content-between">
                              <div class="avatar flex-shrink-0">
                                <img src="/admin/img/icons/unicons/wallet-info.png" alt="Credit Card" class="rounded" />
                              </div>
                              <div class="dropdown">
                                <button class="btn p-0" type="button" id="cardOpt6" data-bs-toggle="dropdown"
                                  aria-haspopup="true" aria-expanded="false">
                                  <i class="bx bx-dots-vertical-rounded"></i>
                                </button>
                              </div>
                            </div>
                            <span>
                              <h3>ĐƠN HÀNG</h3>
                            </span>
                            <h5 class="card-title text-nowrap mb-1" style="color: red;">Số lượng: ${countOrder} đơn</h5>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
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
    </body>

    </html>