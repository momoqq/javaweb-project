<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>${blog.title} | 博客空间</title>
    <link rel="stylesheet" href="css/blog-detail.css">
</head>
<body>
    <%@ include file="includes/header.jspf" %>

    <div class="container">
        <article class="blog-detail">
            <header class="blog-header">
                <h1 class="blog-title">${blog.title}</h1>
                <div class="blog-meta">
                    <span class="blog-author">作者: ${blog.author}</span>
                    <span class="blog-date">发布时间: <fmt:formatDate value="${blog.createTime}" pattern="yyyy-MM-dd HH:mm"/></span>
                </div>
            </header>
            <div class="blog-content">
                <pre>${blog.content}</pre>
            </div>
            <div class="blog-actions">
                <a href="blog" class="btn btn-outline back-link">← 返回博客列表</a>
                <form action="delete-blog" method="post" onsubmit="return confirm('确定要删除这篇博客吗？');">
                    <input type="hidden" name="id" value="${blog.id}">
                    <button type="submit" class="btn btn-danger">删除博客</button>
                </form>
            </div>
        </article>
    </div>

    <%@ include file="includes/footer.jspf" %>
</body>
</html>