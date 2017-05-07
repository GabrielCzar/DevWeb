package com.websi.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String nome = (String) req.getParameter("usuario")
		,      senha = (String) req.getParameter("senha");

		if (nome != null && senha != null &&
				nome.equals("admin") && senha.equals("teste1234")) {
			session.setAttribute("usuario", nome);
			@SuppressWarnings("unchecked")
			ArrayList<String> listaTarefas = (ArrayList<String>) session.getAttribute("lista_tarefas");
			if (listaTarefas == null) {
				listaTarefas = new ArrayList<String>();
				session.setAttribute("lista_tarefas", listaTarefas);
			}
			res.getWriter().print("success");
			// res.sendRedirect("index.html");
		} else 
			session.invalidate();
		
	}
}
