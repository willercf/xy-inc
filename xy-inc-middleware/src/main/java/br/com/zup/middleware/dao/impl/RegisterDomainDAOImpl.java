package br.com.zup.middleware.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.zup.middleware.dao.GenericCrudDAO;
import br.com.zup.middleware.dao.RegisterDomainDAO;
import br.com.zup.model.entities.RegisterDomain;

@Repository("registerDomainDAO")
public class RegisterDomainDAOImpl extends GenericCrudDAO<RegisterDomain, Integer> implements RegisterDomainDAO {

}
