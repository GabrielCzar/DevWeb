package com.websi.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.websi.dao.GenericDao;
import com.websi.model.Servico;
import com.websi.mvc.interfaces.Logica;

public class RemService implements Logica{

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) {
		GenericDao<Servico> dao = new GenericDao<>();
		Long id = Long.parseLong(req.getParameter("id"));
		dao.delete(dao.read(Servico.class, id));
		
		ReadServices readServices = new ReadServices();
		readServices.executa(req, res);
	}

}
