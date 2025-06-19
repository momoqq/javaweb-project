<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
    <div class="login-container">
    <div class="login-header">
        <h1>用户登录</h1>
        <p>欢迎回来，请登录您的账号</p>
    </div>
    <div class="login-form">
        
        <% if (request.getAttribute("errorMessage") != null) { %>
            <div class="error-message"><%= request.getAttribute("errorMessage") %></div>
        <% } %>
        <form action="login" method="post">
            <div class="form-group">
                <label for="username" class="form-label">用户名:</label>
                <input type="text" id="username" name="username" required class="form-input">
            </div>
            <div class="form-group">
                <label for="password" class="form-label">密码:</label>
                <input type="password" id="password" name="password" required class="form-input">
            </div>
            <button type="submit" class="btn">登录</button>
        </form>
    </div>
</div>
</body>
</html>