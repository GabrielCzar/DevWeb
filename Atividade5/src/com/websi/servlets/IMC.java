package com.websi.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/imc")
public class IMC extends HttpServlet{
	private static final long serialVersionUID = 1L;


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Double peso = Double.parseDouble(req.getParameter("peso")),
				altura = Double.parseDouble(req.getParameter("altura"));
		Double imc = peso / (altura * altura);
		res.getWriter().println("Imc: " + imc);
		res.getWriter().println("Classificação: " + imcClassificacao(imc));
	}

	protected String imcClassificacao (Double imc) {
		if (imc < 16)
			return "Magreze grave";
		else if (imc < 17)
			return "Magreza moderada";
		else if (imc < 18.5)
			return "Magreza leve";
		else if (imc < 25)
			return "Saudável";
		else if (imc < 30)
			return "Sobrepeso";
		else if (imc < 35)
			return "Obesidade Grau I";
		else if (imc < 40)
			return "Obesidade Grau II (severa)";
		else
			return "Obesidade Grau III (mórbida)";
	}
}
