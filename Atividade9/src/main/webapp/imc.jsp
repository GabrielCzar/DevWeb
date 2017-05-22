<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> 
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IMC</title>
</head>
<body>
	<c:import url="header.jsp" />	

	<div class="container">
		<div class="panel panel-default">
			<div class="panel-body">
				<h1>IMC</h1>
				<hr>
				<form class="form-inline" action="imc" method="post">
					<div class="form-group">
						<label for="peso">Peso: </label> <input class="form-control" type="number" step="any" placeholder="0" id="peso" name="peso" />
					</div>
					<div class="form-group">
						<label for="altura">Altura: </label> <input class="form-control" type="number" step="any" placeholder="0" id="altura" name="altura" />
					</div>
					<input class="btn btn-success" type="submit" value="Calcular" />
				</form>
			</div>
			<div class="panel-footer">
				<h1>Índice de Massa Corporal: <fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${sessionScope.imc}" /></h1>
				<h3>Classificação: ${sessionScope.classificacao}</h3>
			</div>
		</div>
	</div>
	
	<c:import url="footer.jsp" />
</body>
</html>