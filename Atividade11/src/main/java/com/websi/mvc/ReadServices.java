package com.websi.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.websi.dao.GenericDao;
import com.websi.model.Servico;
import com.websi.model.Servico.Categoria;
import com.websi.model.Servico.Tipo;
import com.websi.mvc.interfaces.Logica;

public class ReadServices implements Logica{
	
	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) {
		GenericDao<Servico> dao = new GenericDao<>();
		List<Servico> servicos = dao.read(Servico.class, "from servicos");
		req.setAttribute("servicos", servicos);
		req.setAttribute("tipos", Tipo.values());
		req.setAttribute("categorias", Categoria.values());
	}

}
