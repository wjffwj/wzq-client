<%@ page import="com.wzq.entity.TranFlow" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 24745
  Date: 2019/11/27
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>请输入查询条件</h4>
<form id="queryForm" method="get" action="/tranflow/search">
   月份： <input type="text" name="month" />&nbsp;&nbsp;&nbsp; 流水号：<input type="text" name="tranflowId"><br>
   卡号：<input type="text" name="cardNo"> &nbsp;&nbsp;&nbsp;  消费日期<input type="date" name="createDate"><br>
    <input type="submit" value="查询"/>
</form>

<a href="${pageContext.request.contextPath}/search/noeat">查询1月份未用过餐的员工信息</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/ccgc/tongji">存储过程统计每个员工1月份的用餐次数</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/fee/fee">统计指定月份公司应付给食堂的费用</a>&nbsp;&nbsp;&nbsp;&nbsp;


<table border="1">
    <tr>
        <th>交易流水</th>
        <th>用户号</th>
        <th>用户名</th>
        <th>卡号</th>
        <th>消费金额</th>
        <th>创建时间戳</th>
        <th>创建日</th>
        <th>消费月份</th>
    </tr>

        <%
            List<TranFlow> list = (List<TranFlow>) request.getAttribute("tranflows");
            for(TranFlow t:list){%>
    <tr>
                <td><%=t.getId()%></td>
                <td><%=t.getUserId()%></td>
                <td><%=t.getUsername()%></td>
                <td><%=t.getCardNo()%></td>
                <td><%=t.getMoney()%></td>
                <td><%=t.getCreated()%></td>
                <td><%=t.getCreateDate()%></td>
                <td><%=t.getMonth()%></td>
    </tr>
        <%}%>


</table>



</body>
</html>
