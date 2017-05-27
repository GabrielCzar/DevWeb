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
		<h1>Produtos</h1>

		<button id="add" class="btn btn-primary">Adicionar</button>

		<form id="form_add" hidden="true" class="form-inline"
			action="produtos" method="post">
			<div class="form-group">
				<input class="form-control" name="descricao" type="text"
					placeholder="Descricao">
			</div>
			<div class="form-group">
				<input class="form-control" name="valor" type="number" step="any"
					placeholder="Valor" />
			</div>
			<div class="form-group">
				<input class="btn btn-success" type="submit" value="Enviar" />
			</div>
		</form>

		<hr>

		<table class="table table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>Descrição</th>
					<th>Valor</th>
				</tr>
			</thead>
			<c:forEach var="produto" items="${ produtos }">
				<tr>
					<td>${ produto.id }</td>
					<td>${ produto.descricao }</td>
					<td>${ produto.valor }</td>
					<td><a class="btn btn-warning" href="produtos_alterar?id=${ produto.id }">Alterar</a>
					</td>
					<td><a class="btn btn-danger" href="produtos_remover?id=${ produto.id }">Remover</a>
					</td>
				</tr>
			</c:forEach>
		</table>

	</div>
	<script src="resources/js/jquery.js"></script>
	<script src="resources/js/script.js"></script>
</body>
</html>
