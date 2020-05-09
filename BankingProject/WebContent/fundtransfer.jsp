<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Current" method="post">
Enter Recipient Account:<input type="number" name="recacc" required="required"><br><br>
Enter Amount:<input type="number" name="amt" required="required"><br><br>
Enter Transaction Password:<input type="password" name="transpass" required="required"><br><br>
<input type="hidden" name="type" value="current">
<input type="hidden" name="operation" value="fundtransfer">
<button type="submit">Transfer</button>
</form>
<br>
<form action="current.jsp">
<button type="submit">Cancel</button>
</form>
</body>
</html>