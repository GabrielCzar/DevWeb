package com.websi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.websi.mvc.interfaces.Logica;

@WebServlet("/mvc")
public class ServicosController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final String PACOTE = "com.websi.mvc.";
	public static final String SiglePageURL = "/WEB-INF/templates/servicos.jsp"; 
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String parametro = req.getParameter("logica");
		String nomeDaClasse = PACOTE + parametro;
		try {
				Class<?> classe = Class.forName(nomeDaClasse);
				Logica logica = (Logica) classe.newInstance();
				logica.executa(req, res);
				req.getRequestDispatcher(SiglePageURL).forward(req, res);
		} catch (Exception	e) {
			throw new ServletException("A lógica de negócios causou uma exceção",	e);
		}
	}
}
