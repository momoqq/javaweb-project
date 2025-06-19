<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
    <div class="login-container">
    <div class="login-header">
        <h1>用户注册</h1>
        <p>创建新账号，开始您的旅程</p>
    </div>
    <div class="login-form">
        
        <% if (request.getAttribute("errorMessage") != null) { %>
            <div class="error-message"><%= request.getAttribute("errorMessage") %></div>
        <% } %>
        <% if (request.getAttribute("successMessage") != null) { %>
            <div class="success-message"><%= request.getAttribute("successMessage") %></div>
        <% } %>
        <form action="register" method="post">
            <div class="form-group">
                <label for="username" class="form-label">用户名:</label>
                <input type="text" id="username" name="username" required class="form-input">
            </div>
            <div class="form-group">
                <label for="password" class="form-label">密码:</label>
                <input type="password" id="password" name="password" required class="form-input">
            </div>
            <div class="form-group">
                <label for="confirmPassword" class="form-label">确认密码:</label>
                <input type="password" id="confirmPassword" name="confirmPassword" required class="form-input">
            </div>
            <button type="submit" class="btn">注册</button>
        </form>
    </div>
</div>
</body>
</html>