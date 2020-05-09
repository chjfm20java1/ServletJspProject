<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="pojopack.Transaction"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="customer.jsp">
<button type="submit">Home</button>
</form>
<h1 align="center" style="color: olive;">STATEMENTS</h1>
<table align="center" border="2" cellspacing="1" height="100" width="1000">
<tr align="center" height="100"  style="background-color: teal;">
<th>TRANSACTION ID</th>
<th>ACCOUNT NUMBER</th>
<th>FIRST NAME</th>
<th>LAST NAME</th>
<th>TRANSACTION TYPE</th>
<th>TRANSACTION AMOUNT</th>
<th>DATE AND TIME</th>
</tr>
<c:forEach items="${requestScope.statement}" var = "s">
<tr align="center" height="75" style="background-color: gray;" >
<td>${s.getTrans_id()}</td>
<td>${s.getAcc_num()}</td>
<td>${s.getFname()}</td>
<td>${s.getLname()}</td>
<td>${s.getTrans_type()}</td>
<td>${s.getTrans_amt()}</td>
<td>${s.getDate_time()}</td>
</tr>
</c:forEach>
</table>
</body>
</html>