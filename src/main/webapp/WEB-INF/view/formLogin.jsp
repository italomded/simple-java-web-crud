<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/page" var="controller" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="${page}?action=Login" method="post">
		<label for="login">Login</label>
		<input name="login" type="text">
		<label for="password">Password</label>
		<input name="password" type="password">
		<input type="submit">
	</form>
	<br>
	<p>Login "admin", Password "admin"</p>
</body>
</html>