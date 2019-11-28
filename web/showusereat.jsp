<%@ page import="com.wzq.entity.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 24745
  Date: 2019/11/27
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>该1月份客户用餐次数统计</h3>
<table border="1">
    <tr>
        <th>用户号</th>
        <th>职位</th>
        <th>用户名</th>
        <th>电话</th>
        <th>部门</th>
        <th>性别</th>
        <th>用餐次数</th>

    </tr>

    <%
        List<User> list = (List<User>) request.getAttribute("users");
        for(User t:list){%>
    <tr>
        <td><%=t.getId()%></td>
        <td><%=t.getPost()%></td>
        <td><%=t.getUsername()%></td>
        <td><%=t.getTel()%></td>
        <td><%=t.getBumen()%></td>
        <td><%=t.getSex()%></td>
        <td><%=t.getTime()%></td>

    </tr>
    <%}%>


</table>


</body>
</html>
