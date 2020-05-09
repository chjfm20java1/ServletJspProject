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
<form action="fundtransfer.jsp">
<input type="submit" value="Fund Transfer"/>
</form>
<br>
<form action="Current" method="post">
<input type="hidden" name="operation" value="view balance"/>
<input type="hidden" name="type" value="current"/> 
<input type="submit" value="View Balance"/>
</form>
<br>
<form action="viewstatement.jsp" method="post">
<input type="submit" value="View Statements"/>
</form>
<br>
<form action="deposit.jsp">
<input type="submit" value="Deposit">
</form>
<br>
<form action="withdraw.jsp">
<button type="submit">Withdraw</button>
</form>
<br>
<form action="customer.jsp">
<input type="submit" value="Home">
</form>



</form>
</body>
</html>