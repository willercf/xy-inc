package br.com.zup.middleware.test.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.zup.middelware.exceptions.PersistenceException;
import br.com.zup.middleware.configuration.MiddlewareConfiguration;
import br.com.zup.middleware.dao.DomainDAO;
import br.com.zup.middleware.dao.RegisterDomainDAO;
import br.com.zup.middleware.test.AbstractTest;
import br.com.zup.model.entities.Domain;
import br.com.zup.model.entities.Field;
import br.com.zup.model.entities.RegisterDomain;
import br.com.zup.model.entities.RegisterField;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MiddlewareConfiguration.class })
@Transactional
public class RegisterDomainDAOTest extends AbstractTest {

	@Autowired
	private DomainDAO domainDAO;

	@Autowired
	private RegisterDomainDAO registerDomainDAO;

	private Domain domain = null;

	private RegisterDomain registerDomain = null;

	@Test
	@Rollback(false)
	public void testSave() {

		try {

			domain = saveDomain();
			registerDomain = buildRegisterDomain(domain);
			registerDomainDAO.save(registerDomain);

			registerDomainDAO.save(registerDomain);
			Assert.assertNotNull(registerDomain.getId());
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}

	@Test
	@Rollback(false)
	public void TestUpdate() {

		try {

			registerDomain = getPersistedRegisterDomain();
			if (registerDomain != null) {

				for (RegisterField registerField : registerDomain.getRegisterFields()) {
					registerField.setValue(registerField.getValue() + " update");
				}

				registerDomainDAO.update(registerDomain);
			} else {
				Assert.assertNull(registerDomain);
			}

		} catch (PersistenceException e) {
			e.printStackTrace();
		}

	}

	@Test
	@Rollback(false)
	public void testDelete() {

		try {

			registerDomain = getPersistedRegisterDomain();

			if (registerDomain != null) {

				registerDomainDAO.delete(registerDomain);
				domainDAO.delete(registerDomain.getDomain());
				Assert.assertNotNull(registerDomain);
				Assert.assertNotNull(registerDomain.getDomain());

			} else {
				Assert.assertNull(registerDomain);
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}

	private Domain saveDomain() throws PersistenceException {

		Domain domain = buildDomainObject();
		domainDAO.save(domain);
		return domain;
	}

	private RegisterDomain buildRegisterDomain(Domain domain) {

		RegisterDomain registerDomain = new RegisterDomain();

		registerDomain.setDomain(domain);

		Set<RegisterField> registerFields = new HashSet<RegisterField>();
		RegisterField registerField = null;

		for (Field field : domain.getFields()) {

			registerField = new RegisterField();
			registerField.setField(field);
			registerField.setRegisterDomain(registerDomain);
			registerField.setValue("Teste Valor: " + field.getName());
			registerFields.add(registerField);
		}
		registerDomain.setRegisterFields(registerFields);

		return registerDomain;
	}

	private RegisterDomain getPersistedRegisterDomain() throws PersistenceException {

		List<RegisterDomain> result = registerDomainDAO.findAll();
		return (result != null && result.size() > 0) ? result.get(0) : null;
	}

}
