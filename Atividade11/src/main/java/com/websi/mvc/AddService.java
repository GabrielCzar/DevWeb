package com.websi.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.websi.dao.GenericDao;
import com.websi.model.Servico;
import com.websi.model.Servico.Categoria;
import com.websi.model.Servico.Tipo;
import com.websi.mvc.interfaces.Logica;

public class AddService implements Logica{

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) {
		String nome = req.getParameter("nome")
		, atividade = req.getParameter("atividade")
		, descricao = req.getParameter("descricao");
		Categoria categoria = Categoria.getCategoria(req.getParameter("categoria"));
		Tipo tipo = Tipo.getTipo(req.getParameter("tipo"));
		
		Servico servico = new Servico(nome, tipo, categoria, atividade, descricao);
		
		GenericDao<Servico> dao = new GenericDao<>();
		
		dao.create(servico);
		
	}

}
