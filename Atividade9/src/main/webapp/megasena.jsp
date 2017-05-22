<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags"	prefix="ufc" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="header.jsp" />
	
	<div class="container">
		<a class="btn btn-default" href="mega">Gerar Números</a>

		<ul class="list-group">
			<c:forEach var="numero" items="${sessionScope.numeros}">
				<ufc:numero value="${ numero }" />
			</c:forEach>
		</ul>
	</div>
	
	<c:import url="footer.jsp" />
</body>
</html>