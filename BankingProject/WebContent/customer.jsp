<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>
<%String name = (String)session.getAttribute("name");
out.print("WELCOME "+name);%></h3>

<form action="savings.jsp">
<div autocapitalize="on">
<button type="submit">Savings</button></div>
</form>
<br>
<form action="current.jsp">
<button type="submit">Current</button>
</form>
<br>
<form action="editprofile.jsp">
<button>Edit Profile</button>
</form>
<br>
<form action="logout.jsp">
<button type="submit">Logout</button>
</form>
</body>
</html>