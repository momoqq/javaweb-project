<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>博客列表</title>
    <link rel="stylesheet" href="css/blog.css">
</head>
<body>
    <%@ include file="includes/header.jspf" %>

    <div class="container">
        <form action="blog" method="get" class="search-form">
            <input type="text" name="search" placeholder="搜索博客..." value="${searchKeyword}">
            <button type="submit">搜索</button>
        </form>
        <c:if test="${empty blogs}">
            <div class="empty-state">
                <div class="empty-icon">📝</div>
                <c:choose>
                    <c:when test="${not empty searchKeyword}">
                        <h3 class="empty-title">未找到结果</h3>
                        <p class="empty-message">没有找到与 "${searchKeyword}" 匹配的博客。</p>
                    </c:when>
                    <c:otherwise>
                        <h3 class="empty-title">暂无博客文章</h3>
                        <p class="empty-message">快去发布你的第一篇博客，分享你的想法吧！</p>
                    </c:otherwise>
                </c:choose>
                <a href="new-blog.jsp" class="btn btn-primary">创建第一篇博客</a>
            </div>
        </c:if>

        <div class="blog-list">
            <c:forEach var="blog" items="${blogs}">
                <article class="blog-post">
                    <header class="blog-header">
                        <h2 class="blog-title">${blog.title}</h2>
                        <div class="blog-meta">
                            <span class="blog-author">✍️ ${blog.author}</span>
                            <span class="blog-date">🕒 <fmt:formatDate value="${blog.createTime}" pattern="yyyy-MM-dd HH:mm"/></span>
                        </div>
                    </header>
                    <div class="blog-content">
                        <p class="blog-excerpt">${fn:substring(blog.content, 0, 200)}${fn:length(blog.content) > 200 ? '...' : ''}</p>
                    </div>
                    <footer class="blog-actions">
                        <a href="blog-detail?id=${blog.id}" class="btn btn-outline">阅读全文</a>
                    </footer>
                </article>
            </c:forEach>
        </div>
    </div>

    <%@ include file="includes/footer.jspf" %>
</body>
</html>