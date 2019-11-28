<%--
  Created by IntelliJ IDEA.
  User: 24745
  Date: 2019/11/25
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>员工消费管理系统</title>
  </head>
  <body>
  <h1>管理员登陆页面</h1>
  <span>${msg}<span><br>
  <form id="loginForm" action="${pageContext.request.contextPath}/admin/login" method="get">
     请输入管理员用户名：<input type="text" name="username" maxlength="10"/><br>
     请输入管理员密码：  <input type="password" name="password" maxlength="10"><br>
     <input type="submit" value="提交"> &nbsp; <input type="reset" value="重置">
  </form>
  </body>
</html>
