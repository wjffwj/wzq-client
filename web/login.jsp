<%--
  Created by IntelliJ IDEA.
  User: 24745
  Date: 2019/11/27
  Time: 1:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功页面</title>
</head>
<body>
<h4>综合管理平台</h4>
<span><a href="http://localhost:8081/addadminRes.jsp">点击此处添加管理员</a> </span>
<span><a href="${pageContext.request.contextPath}/tranflow/list">点击此处查询消费流水</a> </span>


<h5>${msg}</h5>

</body>
</html>
