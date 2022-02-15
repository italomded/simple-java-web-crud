<%@ page import="model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/page" var="controller" />
<span>${ loggedUser.login }, </span>
<a href="${ controller }?action=Logout">logout</a>
<br>
<br>
<br>
