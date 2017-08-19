package br.com.zup.middleware.service;

import java.io.Serializable;
import java.util.List;

import br.com.zup.middelware.exceptions.ServiceException;

public interface BaseCrudService<T, PK extends Serializable> {

	void save(T entity) throws ServiceException;

	T findByPK(PK pk) throws ServiceException;

	List<T> findAll() throws ServiceException;

	void update(T entity) throws ServiceException;

	List<T> findByExample(T entity) throws ServiceException;

	void delete(T entity) throws ServiceException;
}
