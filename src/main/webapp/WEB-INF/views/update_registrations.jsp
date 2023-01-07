<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file = "Menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
<h2>Update|Registrations</h2>
<form action = "Update" method="Post">
email<input type = "text" name = "email" value ="<%=request.getAttribute("email") %>"/>
mobile<input type = "text" name = "mobile"value ="<%=request.getAttribute("mobile") %>"/>
city<input type = "text" name = "city"value ="<%=request.getAttribute("city") %>"/>
<input type = "submit" value = "Update"/>
</form>
</body>
</html>