<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@include file="/resources/taglib.jsp" %>

        <!-- Header Section Begin -->
        <header class="header">
            <div class="header__top">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-6 col-md-6">
                            <div class="header__top__left">
                                <ul>
                                    <li><i class="fa fa-envelope"></i> nguyenminhdao002@gmail.com</li>
                                    <li style="color: #C5A992;">Miễn phí vận chuyển cho đơn hàng từ 369.000 đ</li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6">
                            <div class="header__top__right">
                                <c:if test="${not empty pageContext.request.userPrincipal}">
                                    <div class="header__top__right__language">
                                        <img src="/images/user/${sessionScope.avatar}" style="width: 20px;"
                                            class="rounded-circle" />
                                        <div>${sessionScope.username}</div>
                                        <span class="arrow_carrot-down"></span>
                                        <ul>
                                            <li><a href="/myProfile">Thông tin</a></li>
                                            <li><a href="/cart">Giỏ hàng</a></li>
                                            <li><a href="/orders">Đơn hàng</a></li>
                                            <c:if test="${sessionScope.roleName != 'USER'}">
                                                <li><a href="/admin" target="_blank">Quản trị</a></li>
                                            </c:if>
                                            <li>
                                                <form method="post" action="/logout">
                                                    <button type="submit">Đăng xuất</button>
                                                    <input type="hidden" name="${_csrf.parameterName}"
                                                        value="${_csrf.token}" />
                                                </form>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="header__top__right__social">
                                        <a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a>
                                    </div>
                                </c:if>
                                <c:if test="${empty pageContext.request.userPrincipal}">
                                    <div class="header__top__right__language">
                                        <i class="fa fa-user"></i>
                                        <div> Tài khoản</div>
                                        <span class="arrow_carrot-down"></span>
                                        <ul>
                                            <li><a href="/login">Đăng nhập</a></li>
                                            <li><a href="/register">Đăng ký</a></li>
                                        </ul>
                                    </div>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="header__logo">
                            <a href="/">
                                <h2 style="color: #C5A992; font-weight: bold"><i class="fa fa-book"></i> SWAP STORY</h2>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <nav class="header__menu">
                            <ul>
                                <li class="active"><a href="/" style="color: #C5A992;">Trang Chủ</a></li>
                                <li><a href="/shop">Sản Phẩm</a></li>
                                <li><a href="/blog">Blog</a></li>
                                <li><a href="/contact">Liên Hệ</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="col-lg-3">
                    </div>
                </div>
                <div class="humberger__open">
                    <i class="fa fa-bars"></i>
                </div>
            </div>
        </header>
        <!-- Header Section End -->