package com.websi.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
				Integer pos = Integer.parseInt(req.getParameter("id"));
				String value = listaTarefas.get(pos);
				req.setAttribute("valor", value);
				req.setAttribute("tipo", "alterar");
				RequestDispatcher rd = req.getRequestDispatcher("alterar.html");
				rd.forward(req, res);
			} else if(tipo.equals("apagar")) {
				Integer pos = Integer.parseInt(req.getParameter("id"));
				String value = listaTarefas.get(pos); 
				listaTarefas.remove(value);
				RequestDispatcher rd = req.getRequestDispatcher("index.html");
				rd.forward(req, res);
			} 
		} catch (Exception e) {
			for (int i = 0; i < listaTarefas.size(); i++) 
				out.println("<tr><th class=\"col-md-8\">" + listaTarefas.get(i) + "</th>" + 
							"<th><a class=\"btn\" href=\"lista_tarefas?tipo=alterar&id=" + i + "\">Alterar</a></th>" + 
							"<th><a class=\"btn\" href=\"lista_tarefas?tipo=apagar&id=" + i + "\">Apagar</a></th></tr>");
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
		
		try{
			String tipo = (String) req.getParameter("tipo");
			if (tipo.equals("alterar")) {
				Integer pos = Integer.parseInt(req.getParameter("id"));
				listaTarefas.set(pos, nova_tarefa);
				res.sendRedirect("index.html");
			}
		} catch (Exception e) {
			if (nova_tarefa != null && !nova_tarefa.isEmpty()) {
				listaTarefas.add(nova_tarefa);
				res.getWriter().print("success");
			}			
		}
	}
}
