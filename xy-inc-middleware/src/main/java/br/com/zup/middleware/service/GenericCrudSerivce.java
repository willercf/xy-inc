package br.com.zup.middleware.service;

import java.io.Serializable;
import java.util.List;

import br.com.zup.middelware.exceptions.ServiceException;
import br.com.zup.middleware.dao.BaseCrudDAO;

public abstract class GenericCrudSerivce<T, PK extends Serializable> implements BaseCrudService<T, PK> {

	public abstract BaseCrudDAO<T, PK> getDAO();

	public void save(T entity) throws ServiceException {

		try {
			getDAO().save(entity);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	public T findByPK(PK pk) throws ServiceException {

		try {
			return getDAO().findByPK(pk);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	public List<T> findAll() throws ServiceException {

		try {

			return getDAO().findAll();
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	public void update(T entity) throws ServiceException {

		try {
			getDAO().update(entity);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	public List<T> findByExample(T entity) throws ServiceException {

		try {
			return getDAO().findByExample(entity);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	public void delete(T entity) throws ServiceException {

		try {
			getDAO().delete(entity);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

}
