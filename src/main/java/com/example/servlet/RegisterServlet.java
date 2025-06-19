package com.example.servlet;

import com.example.dao.UserDAO;
import com.example.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        // 验证参数
        if (username == null || username.isEmpty() || password == null || password.isEmpty() || confirmPassword == null || confirmPassword.isEmpty()) {
            request.setAttribute("errorMessage", "所有字段不能为空");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // 验证密码是否一致
        if (!password.equals(confirmPassword)) {
            request.setAttribute("errorMessage", "两次输入的密码不一致");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // 检查用户名是否已存在
        if (userDAO.getUserByUsername(username) != null) {
            request.setAttribute("errorMessage", "用户名已存在");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // 创建新用户并添加到数据库
        User newUser = new User(username, password);
        boolean isAdded = userDAO.addUser(newUser);

        if (isAdded) {
            request.setAttribute("successMessage", "注册成功，请登录");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "注册失败，请重试");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理GET请求，直接转发到注册页面
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }
}