<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="customer.jsp">
<button type="submit">Home</button>
</form>
<div align="center" style="font-style: normal;font-size: xx-large;color: blue;">Your Current Balance
<br>
<br>
</div>
<div align="center" style="font-style: normal;font-size: xx-large;">
<%out.println(request.getAttribute("balance")); %>
</div>

</body>
</html>