<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Savings" method="post">
Enter the amount : <input type="number" name="amnt">
<input type="hidden" name="type" value="savings">
<input type="hidden" name="operation" value="deposit">
<input type="submit" value="Deposit">
</form>
</body>
</html>