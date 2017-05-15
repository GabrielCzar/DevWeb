<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<%@ include file='header.jsp'%>
	<div class="container">
		<div class="row">
			<div class="col-md-4" role="group">
				<a class="thumbnail btn btn-lg btn-default" href="imc.jsp">
					Indice de Massa Corporal</a>
			</div>
			<div class="col-md-4" role="group">
				<a class=" thumbnail btn btn-lg btn-default" href="somasub.jsp">Soma
					e Subtração</a>
			</div>
			<div class="col-md-4" role="group">
				<a class="thumbnail btn btn-lg btn-default" href="megasena.jsp">MegaSena</a>
			</div>
		</div>
	</div>

	<%@ include file='footer.jsp'%>

</body>
</html>