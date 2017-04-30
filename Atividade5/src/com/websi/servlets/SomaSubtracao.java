package com.websi.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/soma_subtracao")
public class SomaSubtracao extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Double x = Double.parseDouble(req.getParameter("x")),
				y = Double.parseDouble(req.getParameter("y"));
		Double soma = x + y,
				subtracao = x - y;
		res.getWriter().println("Soma: " + soma);
		res.getWriter().println("Subtração: " + subtracao);
	}
}
