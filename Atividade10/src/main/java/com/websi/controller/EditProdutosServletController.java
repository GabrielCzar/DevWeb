package com.websi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.websi.dao.ProdutoDao;
import com.websi.model.Produto;

@WebServlet("/produtos_alterar")
public class EditProdutosServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProdutoDao dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = new ProdutoDao();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		Produto produto = dao.getProduto(id);
		req.setAttribute("produto", produto);
		req.getRequestDispatcher("produtos_alterar.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		String descricao = req.getParameter("descricao");
		Double valor = Double.parseDouble(req.getParameter("valor"));
		Produto produto = new Produto(id, descricao, valor);
		dao.updateProduto(produto);
		res.sendRedirect(req.getContextPath() + "/produtos");
	}
}
