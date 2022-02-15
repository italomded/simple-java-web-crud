<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/page" var="controller" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager</title>
</head>
<body>
	<c:import url="/WEB-INF/view/login-bar.jsp"/>
	<ul>
		<c:forEach items="${ products }" var="product">
			<li>
			<span>${ product.name }, ${ product.quantity } </span>
			<a href="${ controller }?action=FormUpdateProduct&id=${ product.id }">update</a>
			<span> /</span>
			<a href="${ controller }?action=DeleteProduct&id=${ product.id }">remove</a>
			</li>
		</c:forEach>
		<li>
			<a href="${ controller }?action=FormCreateProduct">create</a>
		</li>
	</ul>
</body>
</html>