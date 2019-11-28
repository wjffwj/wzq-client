<%--
  Created by IntelliJ IDEA.
  User: 24745
  Date: 2019/11/27
  Time: 1:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>新增管理员页面</h1>
<h4>${msg}</h4>
<form action="${pageContext.request.contextPath}/add/addadmin" method="get">
    请输入要新增的管理员用户名：<input type="text" name="username" maxlength="10"><br>
    请输入要新增的管理员密码 ： <input type="password" name="password" maxlength="10"><br>
                    <input type="submit" value="注册">
</form>
</body>
</html>
