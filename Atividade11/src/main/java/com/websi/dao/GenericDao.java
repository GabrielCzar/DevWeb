package com.websi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.websi.dao.interfaces.IGenericDao;

public class GenericDao<G> implements IGenericDao<G>{
	private EntityManagerFactory factory;
	@PersistenceContext
	private EntityManager manager;

	public GenericDao() {
		factory = Persistence.createEntityManagerFactory("dev");
		manager = factory.createEntityManager();
	}

	@Override
	public boolean create(G object) {
		try{
			manager.getTransaction().begin();
			manager.merge(object);
			manager.clear();
			manager.getTransaction().commit();
			return true;
		}catch(PersistenceException e){
			e.printStackTrace();
			manager.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public G read(Class<G> classe, Long id) {
		try{
			return manager.find(classe , id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<G> read(Class<G> classe, String jpql){
		try{
			return manager.createQuery(jpql, classe).getResultList();
		}catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean update(G object) {
		try{
			manager.getTransaction().begin();
			manager.merge(object);
			manager.getTransaction().commit();
			return true;
		}catch (PersistenceException e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public boolean delete(G object) {
		try{
			manager.getTransaction().begin();
			manager.remove(object);
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			manager.getTransaction().rollback();
			return false;
		}
	}

}