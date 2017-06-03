package com.websi.dao.interfaces;

import java.util.List;

public interface IGenericDao<G>{

	public boolean create(G object);

	public G read(Class<G> classe, Long id);
	public List<G> read(Class<G> classe, String jpql);
	
	public boolean update(G object);

	public boolean delete(G object);

}
