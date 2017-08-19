package br.com.zup.middleware.dao;

import java.io.Serializable;
import java.util.List;

import br.com.zup.middelware.exceptions.PersistenceException;

public interface BaseCrudDAO<T, PK extends Serializable> {

	Class<T> getPersistentClass();

	void save(T entity) throws PersistenceException;

	T findByPK(PK pk) throws PersistenceException;

	List<T> findAll() throws PersistenceException;

	void update(T entity) throws PersistenceException;

	List<T> findByExample(T entity) throws PersistenceException;

	void delete(T entity) throws PersistenceException;
}
