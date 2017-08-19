package br.com.zup.middleware.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.zup.middleware.dao.DomainDAO;
import br.com.zup.middleware.dao.GenericCrudDAO;
import br.com.zup.model.entities.Domain;

@Repository("domainDAO")
public class DomainDAOImpl extends GenericCrudDAO<Domain, Integer> implements DomainDAO {

}
