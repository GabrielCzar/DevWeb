package com.websi.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/lista_tarefas")
public class ListaTarefas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		HttpSession session = req.getSession();
		ArrayList<String> listaTarefas = (ArrayList<String>) session.getAttribute("lista_tarefas");
		try {
			String tipo = (String) req.getParameter("tipo");
			
			if (tipo.equals("alterar")) {
				// SOMETHING
			} else if(tipo.equals("apagar")) {
				Integer pos = Integer.parseInt(req.getParameter("pos"));
				String value = listaTarefas.get(pos); 
				out.print(listaTarefas.remove(value));
			} 
		} catch (Exception e) {
			for (int i = 0; i < listaTarefas.size(); i++) 
				out.println("<tr><th class=\"col-md-8\">" + listaTarefas.get(i) + "</th>" + 
							"<th><a class=\"btn\" id=\"alterar" + i + "\">Alterar</a></th>" + 
							"<th><a class=\"btn\" id=\"apagar" + i + "\">Apagar</a></th></tr>");
		} 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<String> listaTarefas = (ArrayList<String>) session.getAttribute("lista_tarefas");
		String nova_tarefa = (String) req.getParameter("nova_tarefa");
		
		if (listaTarefas == null) {
			listaTarefas = new ArrayList<String>();
			session.setAttribute("lista_tarefas", listaTarefas);
		}
		
		if (nova_tarefa != null && !nova_tarefa.isEmpty()) {
			listaTarefas.add(nova_tarefa);
			res.getWriter().print("success");
		}
	}
}
