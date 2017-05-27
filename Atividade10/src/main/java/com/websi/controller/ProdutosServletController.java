package com.websi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.websi.dao.ProdutoDao;
import com.websi.model.Produto;

@WebServlet({"/produtos"})
public class ProdutosServletController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ProdutoDao dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = new ProdutoDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<Produto> produtos = dao.getAllProdutos();
		req.setAttribute("produtos", produtos);
		req.getRequestDispatcher("produtos.jsp").forward(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String descricao = req.getParameter("descricao");
		Double valor = Double.parseDouble(req.getParameter("valor"));
		Produto produto = new Produto(descricao, valor);
		dao.insert(produto);
		doGet(req, res);
	}
}

