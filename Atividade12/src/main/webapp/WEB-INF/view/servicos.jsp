<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Atividade 11</title>
	<link rel="stylesheet" href="css/materialize.min.css" />
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
	<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<nav class="blue lighten-2">
		<div class="nav-wrapper container">
			<h3 class="brand-logo center"><a href="/servicos">Serviços</a></h3>
		</div>
	</nav>

	<div class="fixed-action-btn horizontal">
		<a href="#modal1" class="btn-floating btn-large green modal-trigger">
			<i class="large material-icons">add</i>
		</a>
	</div>

	<!-- Modal Structure -->
	<div id="modal1" class="modal bottom-sheet">
		<div class="modal-content">
			<div class="container">
				<h3>Adicionar Serviço</h3>
				<form class="col s12" action="/servicos/add" method="post">
					<div class="row">
						<div class="input-field col s4">
							<input name="nome" id="name" type="text" class="validate">
							<label for="name">Nome</label>
						</div>
						<div class="input-field col s4">
							<input name="atividade" id="atvform" type="text" class="validate">
							<label for="atvform">Atividade</label>
						</div>
						<div class="input-field col s4">
							<input name="descricao" id="descform" type="text"
								class="validate"> <label for="descform">Descricao</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s6">
							<select name="tipo">
								<option value="" disabled selected>Escolha o tipo</option>
								<c:forEach var="tipo" items="${ tipos }">
									<option value="${ tipo }">${ tipo }</option>
								</c:forEach>
							</select> <label>Tipo</label>
						</div>
						<div class="input-field col s6">
							<select name="categoria">
								<option value="" disabled selected>Escolhas as
									categorias</option>
								<c:forEach var="categoria" items="${ categorias }">
									<option value="${ categoria }">${ categoria }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<button class="btn waves-effect waves-light" type="submit"
						name="action">
						Enviar <i class="material-icons right">send</i>
					</button>
					<button class="btn waves-effect waves-light red" type="reset"
						name="action">
						Limpar <i class="material-icons right">clear</i>
					</button>
				</form>
			</div>

		</div>
		<div class="modal-footer">
			<a href="#!"
				class="modal-action modal-close waves-effect waves-green btn-flat">Cancelar</a>
		</div>
	</div>

	<div class="container">

		<table class="responsive-table highlight">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Tipo</th>
					<th>Categoria</th>
					<th>Atividade</th>
					<th>Descrição</th>
					<th>Opções</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="servico" items="${ servicos }">
					<tr>
						<td>${ servico.nome }</td>
						<td>${ servico.tipo }</td>
						<td>${ servico.categoria }</td>
						<td>${ servico.atividade }</td>
						<td>${ servico.descricao }</td>
						<td><a class="modal-trigger btn yellow lighten-1"
							href="#modaledit${ servico.id }">Editar<span
								class="small material-icons">edit</span></a> <a
							class="btn red lighten-1"
							href="/servicos/${ servico.id }/delete">Apagar<span
								class="small material-icons">delete</span></a>
							<div id="modaledit${ servico.id }"
								class="modal modal-fixed-footer">
								<div class="modal-content">
									<h3>Editar Serviço</h3>
									<form class="col s12" action="/servicos/${ servico.id }/update"
										method="post">
										<input name="id" value="${ servico.id }" hidden="true">
										<div class="row">
											<div class="input-field col s4">
												<input name="nome" id="name" type="text" class="validate"
													value="${ servico.nome }"> <label for="name">Nome</label>
											</div>
											<div class="input-field col s4">
												<input name="atividade" id="atv" type="text"
													class="validate" value="${ servico.atividade }"> <label
													for="atv">Atividade</label>
											</div>
											<div class="input-field col s4">
												<input name="descricao" id="desc" type="text"
													class="validate" value="${ servico.descricao }"> <label
													for="desc">Descricao</label>
											</div>
										</div>
										<div class="row">
											<div class="input-field col s6">
												<select name="tipo">
													<c:forEach var="tipo" items="${ tipos }">
														<c:if test="${ tipo == servico.tipo }">
															<option value="${ tipo }" selected="selected">${ tipo }</option>
														</c:if>
														<c:if test="${ tipo != servico.tipo }">
															<option value="${ tipo }">${ tipo }</option>
														</c:if>
													</c:forEach>
												</select> <label>Tipo</label>
											</div>
											<div class="input-field col s6">
												<select name="categoria">
													<c:forEach var="categoria" items="${ categorias }">
														<c:if test="${ categoria == servico.categoria }">
															<option value="${ categoria }" selected="selected">${ categoria }</option>
														</c:if>
     													<c:if test="${ categoria != servico.categoria }">
															<option value="${ categoria }">${ categoria }</option>
														</c:if>
													</c:forEach>
												</select>
											</div>
										</div>
										<button class="btn waves-effect waves-light" type="submit"
											name="action">
											Enviar <i class="material-icons right">send</i>
										</button>
										<button class="btn waves-effect waves-light red" type="reset"
											name="action">
											Limpar <i class="material-icons right">clear</i>
										</button>
									</form>
								</div>
								<div class="modal-footer">
									<a href="#!"
										class="modal-action modal-close waves-effect waves-green btn-flat ">Cancelar</a>
								</div>
							</div></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="js/jquery.js"></script>
	
	<script src="js/materialize.js"></script>
	
	<script src="js/script.js"></script>
</body>
</html>
