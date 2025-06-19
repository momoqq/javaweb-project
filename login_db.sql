CREATE DATABASE login_db;
USE login_db;
-- 创建博客表
CREATE TABLE IF NOT EXISTS blogs (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    author VARCHAR(100) NOT NULL,
    create_time DATETIME NOT NULL
);

-- 创建用户表
CREATE TABLE IF NOT EXISTS users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE,
    create_time DATETIME NOT NULL
);

-- 可选：插入测试数据
INSERT INTO blogs (title, content, author, create_time) VALUES
('我的第一篇博客', '这是使用JSP+Servlet创建的博客系统测试文章。', 'testuser', NOW()),
('JavaWeb学习笔记', 'Servlet和JSP是JavaWeb开发的核心技术...', 'testuser', NOW());