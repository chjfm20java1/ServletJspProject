<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center" style="color: aqua;">Please take your cash!</h1>
<div align="center" style="font-size: xx-large;">Your Current Balance :<br><br>
<%out.println(request.getAttribute("balance")); %> 
</div>
<br><br>
<div align="center">
<form action="customer.jsp">
<button type="submit">HOME</button>
</form>
</div>
</body>
</html>