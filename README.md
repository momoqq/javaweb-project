# 计算机博客系统

## 项目概述
这是一个基于JavaWeb技术栈开发的博客系统，提供用户注册、登录功能以及博客文章的展示和管理。系统采用MVC架构，使用JSP作为视图层，Servlet作为控制器，MySQL作为数据库存储。

## 技术栈
- **后端**: Java, Servlet 6.0, JSP 3.1, JSTL
- **数据库**: MySQL 8.0
- **构建工具**: Maven
- **服务器**: Apache Tomcat 11
- **前端**: HTML, CSS

## 功能特点
- 用户注册与登录
- 博客文章列表展示
- 博客文章详情查看
- 示例数据包含20篇计算机相关技术文章

## 环境要求
- JDK 21+
- Maven 3.6+
- MySQL 8.0+
- Apache Tomcat 11+

## 安装与配置

### 1. 克隆项目
```bash
# 克隆仓库到本地
git clone <repository-url>
cd java-web
```

### 2. 数据库配置
1. 登录MySQL数据库
```bash
mysql -u root -p
```

2. 执行SQL脚本创建数据库和表
```bash
# 创建数据库和表结构
source login_db.sql

# 导入示例博客数据
source computer_blogs.sql
```

3. 修改数据库连接配置（可选）
编辑 `src/main/resources/db.properties` 文件，更新数据库连接信息：
```properties
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/login_db?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false
jdbc.username=root
jdbc.password=Zhy183845
```

### 3. 构建与运行
```bash
# 使用Maven构建项目
mvn clean package

# 启动Tomcat服务器
mvn tomcat11:run
```

4. 访问系统
打开浏览器访问: [http://localhost:8080](http://localhost:8080)

## 项目结构
```
java-web/
├── src/
│   └── main/
│       ├── java/        # Java源代码
│       ├── resources/   # 配置文件
│       └── webapp/      # Web资源
│           ├── css/     # 样式表
│           ├── images/  # 图片资源
│           ├── includes/ # 页面组件
│           └── *.jsp     # JSP页面
├── pom.xml              # Maven配置
├── login_db.sql         # 数据库结构脚本
└── computer_blogs.sql   # 示例数据脚本
```

## 使用说明
1. 访问系统首页，点击注册按钮创建新账号
2. 使用注册的账号登录系统
3. 浏览博客文章列表，点击文章标题查看详情

## 许可证
本项目采用MIT许可证 - 详情参见LICENSE文件