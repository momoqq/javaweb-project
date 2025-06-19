<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布新博客 | 博客空间</title>
    <link rel="stylesheet" href="css/new-blog.css">
</head>
<body>
    <%@ include file="includes/header.jspf" %>

    <div class="container">
        <article class="form-container">
            <h1 class="form-title">发布新博客</h1>
            <% if (request.getAttribute("errorMessage") != null) { %>
                <div class="error-message"><%= request.getAttribute("errorMessage") %></div>
            <% } %>
            <form action="blog" method="post">
                <div class="form-group">
                    <label for="title" class="form-label">标题:</label>
                    <input type="text" id="title" name="title" required class="form-input" placeholder="输入博客标题...">
                </div>
                <div class="form-group">
                    <label for="author" class="form-label">作者:</label>
                    <input type="text" id="author" name="author" required class="form-input" placeholder="输入你的名字...">
                </div>
                <div class="form-group">
                    <label for="createTime" class="form-label">发布时间:</label>
                    <input type="datetime-local" id="createTime" name="createTime" required class="form-input">
                </div>
                <div class="form-group">
                    <label for="content" class="form-label">内容:</label>
                    <textarea id="content" name="content" required class="form-input" placeholder="分享你的想法..." rows="10"></textarea>
                </div>
                <div class="form-actions">
                    <button type="submit" class="btn btn-primary">发布博客</button>
                    <a href="blog" class="btn btn-outline">取消</a>
                </div>
            </form>
        </article>
    </div>

    <%@ include file="includes/footer.jspf" %>
</body>
</html>