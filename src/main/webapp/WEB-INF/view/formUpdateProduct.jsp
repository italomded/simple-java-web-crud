<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/page" var="controller" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Product</title>
</head>
<body>
	<c:import url="/WEB-INF/view/login-bar.jsp"/>
	<form action="${page}?action=UpdateProduct" method="post">
	<label for="name">Name</label>
	<input name="name" type="text" value="${ product.name }">
	<label for="quantity">Quantity</label>
	<input name="quantity" type="text" value="${ product.quantity }">
	<input name="id" type="hidden" value="${ product.id }">
	<input type="submit">
	</form>
</body>
</html>