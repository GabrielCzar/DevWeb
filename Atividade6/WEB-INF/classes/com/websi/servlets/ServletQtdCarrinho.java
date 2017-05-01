package com.websi.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.websi.model.Produto;

@WebServlet("/quantidade_carrinho")
public class ServletQtdCarrinho extends HttpServlet {
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
		
		res.getWriter().print(listaProdutos.size());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
