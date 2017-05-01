package com.websi.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.websi.model.Produto;

@WebServlet("/carrinho")
public class ServletCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		List<Produto> listaProdutos = (List<Produto>) session.getAttribute("lista_de_produtos");
		
		// Tratando exception
		if (listaProdutos == null) {
			listaProdutos = new ArrayList<>();
			session.setAttribute("lista_de_produtos", listaProdutos);
		}
		// Saida
		Double total = 0.0;
		PrintWriter out = res.getWriter();
		out.println("<table><thead><tr><th>Produto</th><th>Preco</th><th>Quantidade</th></tr></thead>");
		for (Produto p : listaProdutos) { 
			out.println("<tr><th>" + p.getNome() 
					+ "</th><th> R$ " + p.getPreco() 
					+ "</th><th>" + p.getQuantidade() + "</th></tr>");
			total += (p.getPreco() * p.getQuantidade());
		}
		out.println("<tfoot><tr><th>Total: </th><th> R$ " + total + "</th><tr></tfoot></table>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
