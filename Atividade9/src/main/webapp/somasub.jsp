<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Soma e Subtracao</title>
</head>
<body>
	<c:import url="header.jsp" />
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-body">
				<h1>Soma e Subtração</h1>
				<hr>
				<form class="form-inline" action="soma_subtracao" method="post">
					<div class="form-group">
						<label for="x">Valor 1: </label> 
						<input class="form-control" type="number" step="any"
							placeholder="0" id="x" name="x" />
					</div>
					<div class="form-group">
						<label for="y">Valor 2: </label> 
						<input class="form-control" type="number" step="any"
							placeholder="0" id="y" name="y" />
					</div>
					<input class="btn btn-success" type="submit" value="Calcular" />
				</form>
			</div>
			<div class="panel-footer">
				<h1>Soma: <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${sessionScope.soma}" /></h1>
				<h1>Subtraçao: <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${sessionScope.subtracao}" /></h1>
			</div>
		</div>
	</div>
	
	<c:import url="footer.jsp" />
</body>
</html>