package com.example.servlet;

import com.example.dao.BlogDAO;
import com.example.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteBlogServlet extends HttpServlet {
    private BlogDAO blogDAO = new BlogDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String idParam = request.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            response.sendRedirect("blog");
            return;
        }

        try {
            int blogId = Integer.parseInt(idParam);
            blogDAO.deleteBlogById(blogId);
            response.sendRedirect("blog");
        } catch (NumberFormatException e) {
            response.sendRedirect("blog");
        }
    }
}