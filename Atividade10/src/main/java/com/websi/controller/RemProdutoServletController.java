package com.websi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.websi.dao.ProdutoDao;

@WebServlet("/produtos_remover")
public class RemProdutoServletController  extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ProdutoDao dao = new ProdutoDao();
		Long id = Long.parseLong(req.getParameter("id"));
		dao.removeProduto(id);
		res.sendRedirect(req.getContextPath() + "/produtos");
	}
}
