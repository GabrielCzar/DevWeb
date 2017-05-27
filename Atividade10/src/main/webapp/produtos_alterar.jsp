<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Produtos</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<h1>Alterar Produto</h1>

		<form class="form-inline" action="produtos_alterar" method="post">
			<input name="id" value="${ produto.id }" hidden="true">
			<div class="form-group">
				<input class="form-control" name="descricao" type="text"
					placeholder="Descricao" value="${ produto.descricao }">
			</div>
			<div class="form-group">
				<input class="form-control" name="valor" type="number" step="any"
					placeholder="Valor" value="${ produto.valor }">
			</div>
			<div class="form-group">
				<a class="btn btn-info" href="produtos">Voltar</a>
				<input class="btn btn-success" type="submit" value="Alterar">
			</div>
		</form>

	</div>
</body>
</html>
