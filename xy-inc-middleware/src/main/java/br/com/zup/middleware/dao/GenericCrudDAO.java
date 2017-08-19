package br.com.zup.middleware.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.zup.middelware.exceptions.PersistenceException;

@Transactional
public abstract class GenericCrudDAO<T, PK extends Serializable> implements BaseCrudDAO<T, PK> {

	@Autowired
	private SessionFactory sessionFactory;

	private Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public GenericCrudDAO() {

		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	protected Session getSession() {

		return sessionFactory.getCurrentSession();
	}

	protected Criteria createCriteria() {

		return getSession().createCriteria(persistentClass);
	}

	public void save(T entity) throws PersistenceException {

		try {
			getSession().persist(entity);
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public T findByPK(PK pk) throws PersistenceException {

		try {
			return (T) getSession().get(persistentClass, pk);
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() throws PersistenceException {

		try {

			Criteria criteria = createCriteria();
			return (List<T>) criteria.list();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}

	public void update(T entity) throws PersistenceException {

		try {
			getSession().update(entity);
		} catch (Exception e) {
			throw new PersistenceException(e);
		}

	}

	@SuppressWarnings("unchecked")
	public List<T> findByExample(T entity) throws PersistenceException {

		try {

			Example ex = Example.create(entity);
			Criteria criteria = createCriteria();
			criteria.add(ex);
			return criteria.list();
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}

	public void delete(T entity) throws PersistenceException {

		try {
			getSession().delete(entity);
		} catch (Exception e) {
			throw new PersistenceException(e);
		}
	}
}
