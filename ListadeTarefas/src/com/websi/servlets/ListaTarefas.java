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
		HttpSession session = req.getSession();
		ArrayList<String> listaTarefas = (ArrayList<String>) session.getAttribute("lista_tarefas");
		String tipo = (String) req.getParameter("tipo");
		if (tipo.equals("alterar")) {
		
		} else if(tipo.equals("delete")) {
			Integer pos = Integer.parseInt(req.getParameter("id"));
			if (pos != null) listaTarefas.remove(pos);
		} else get(res.getWriter(), listaTarefas);
	}
	
	private void get (PrintWriter out, ArrayList<String> listaTarefas) {
		for (int i = 0; i < listaTarefas.size(); i++) 
			out.println("<tr><th class=\"col-md-8\">" + listaTarefas.get(i) + "</th>" + 
						"<th><a class=\"btn\" id=\"lista_tarefas?tipo=alterar&id" + i + "\">Alterar</a></th>" + 
						"<th><a class=\"btn\" id=\"lista_tarefas=tipo=delete&id" + i + "\">Apagar</a></th></tr>");
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
