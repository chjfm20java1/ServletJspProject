<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center" style="font-size: xx-large;" >Sorry!!! Your Transaction could not be processed</div><br><br>
<div align="center" style="font-size: x-large; color: red;">INSUFFICIENT BALANCE</div><br><br>
<div align="center" style="font-size: large;">
Do you want to continue transaction?
<br><br>
<form action="savewithdraw.jsp">
<button type="submit">Yes</button>
</form>
<br>
<form action="customer.jsp">
<button type="submit">No</button>
</form>
</div>
</body>
</html>