<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ChangeInfo" method="post">
Enter new password : <input type="text" name="newtranspass"/>
<input type="hidden" name="type" value="changepass">
<button type="submit">Submit</button>
</form>
</body>
</html>