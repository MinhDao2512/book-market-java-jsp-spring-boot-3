<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>ĐĂNG KÝ THÀNH VIÊN</title>
            <style>
                body {
                    font-family: Arial, sans-serif;
                    line-height: 1.6;
                    color: #333;
                    max-width: 600px;
                    margin: 0 auto;
                    padding: 20px;
                }

                .header {
                    background-color: #f8f9fa;
                    padding: 20px;
                    text-align: center;
                    margin-bottom: 20px;
                }

                .content {
                    padding: 20px;
                    background-color: #ffffff;
                    border: 1px solid #ddd;
                    border-radius: 5px;
                }

                .footer {
                    text-align: center;
                    padding: 20px;
                    font-size: 12px;
                    color: #666;
                    margin-top: 20px;
                }

                .button {
                    display: inline-block;
                    padding: 10px 20px;
                    background-color: #007bff;
                    color: #ffffff;
                    text-decoration: none;
                    border-radius: 5px;
                    margin: 20px 0;
                }
            </style>
        </head>

        <body>
            <div class="header">
                <h1>Story Swap</h1>
            </div>

            <div class="content">
                <p>Xin chào ${userName},</p>

                <p>Bạn đã đăng ký tài khoản thành công</p>

                <p>
                    Nếu bạn có bất kỳ câu hỏi nào, vui lòng liên hệ với chúng tôi.
                </p>
            </div>

            <div class="footer">
                <p>
                    Email này được gửi tự động, vui lòng không trả lời.
                </p>
            </div>
        </body>

        </html>