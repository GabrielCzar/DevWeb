<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file='header.jsp'%>
	<div class="container">
		<a class="btn btn-default" href="mega">Gerar Números</a>

		<ul class="list-group">
			<c:forEach var="numero" items="${sessionScope.numeros}">

				<h3>
					<span class="label label-default">${numero}</span>
				</h3>

			</c:forEach>
		</ul>
	</div>
	<%@ include file='footer.jsp'%>
</body>
</html>