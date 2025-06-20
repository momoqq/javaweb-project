package com.example.servlet;

import com.example.dao.BlogDAO;
import com.example.model.Blog;
import com.example.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class BlogServlet extends HttpServlet {
    private BlogDAO blogDAO = new BlogDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 检查用户是否登录
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // 获取操作类型和搜索参数
        String action = request.getParameter("action");
        String searchKeyword = request.getParameter("search");
        List<Blog> blogs;

        // 处理归档页面请求
        if ("archive".equals(action)) {
            blogs = blogDAO.getBlogsByDateAsc();
            request.setAttribute("blogs", blogs);
            request.getRequestDispatcher("archive.jsp").forward(request, response);
            return;
        }

        // 处理常规博客列表和搜索请求
        if (searchKeyword != null && !searchKeyword.isEmpty()) {
            blogs = blogDAO.searchBlogs(searchKeyword);
            request.setAttribute("searchKeyword", searchKeyword);
        } else {
            blogs = blogDAO.getAllBlogs();
        }
        request.setAttribute("blogs", blogs);

        // 转发到博客列表页面
        request.getRequestDispatcher("blog.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求编码
        request.setCharacterEncoding("UTF-8");

        // 检查用户是否登录
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // 获取表单参数
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        // 验证参数
        if (title == null || title.isEmpty() || content == null || content.isEmpty()) {
            request.setAttribute("errorMessage", "标题和内容不能为空");
            request.getRequestDispatcher("new-blog.jsp").forward(request, response);
            return;
        }

        // 创建新博客
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setAuthor(user.getUsername());
        blog.setCreateTime(new Date());

        // 保存到数据库
        boolean isAdded = blogDAO.addBlog(blog);
        if (isAdded) {
            // 添加成功，重定向到博客列表
            response.sendRedirect("blog");
        } else {
            request.setAttribute("errorMessage", "发布博客失败，请重试");
            request.getRequestDispatcher("new-blog.jsp").forward(request, response);
        }
    }
}