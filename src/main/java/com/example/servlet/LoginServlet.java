package com.example.servlet;

import com.example.dao.UserDAO;
import com.example.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 验证参数
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("errorMessage", "用户名和密码不能为空");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        // 查询用户
        User user = userDAO.getUserByUsername(username);

        // 验证用户
        if (user == null || !user.getPassword().equals(password)) {
            request.setAttribute("errorMessage", "用户名或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        // 登录成功，创建会话
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        // 重定向到博客页面
        response.sendRedirect("blog");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理GET请求，直接转发到登录页面
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}