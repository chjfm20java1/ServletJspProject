<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3><%out.println("HI "+session.getAttribute("name")); %></h3>
<form action="savfundtransfer.jsp">
<input type="submit" value="Fund Transfer"/>
</form>
<br>
<form action="Savings" method="post">
<input type="hidden" name="operation" value="view balance"/>
<input type="hidden" name="type" value="savings"/> 
<input type="submit" value="View Balance"/>
</form>
<br>
<form action="savviewstatement.jsp" method="post">
<input type="submit" value="View Statements"/>
</form>
<br>
<form action="savedeposit.jsp">
<input type="submit" value="Deposit">
</form>
<br>
<form action="savewithdraw.jsp">
<button type="submit">Withdraw</button>
</form>
<br>
<form action="customer.jsp">
<input type="submit" value="Home">
</form>
</body>
</html>