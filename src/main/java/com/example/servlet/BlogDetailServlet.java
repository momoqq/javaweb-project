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

public class BlogDetailServlet extends HttpServlet {
    private BlogDAO blogDAO = new BlogDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 检查用户是否登录
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // 获取博客ID参数
        String idParam = request.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            response.sendRedirect("blog");
            return;
        }

        try {
            int blogId = Integer.parseInt(idParam);
            Blog blog = blogDAO.getBlogById(blogId);
            if (blog == null) {
                response.sendRedirect("blog");
                return;
            }
            request.setAttribute("blog", blog);
            request.getRequestDispatcher("blog-detail.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect("blog");
        }
    }
}