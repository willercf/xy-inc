package br.com.zup.middleware.test.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.zup.middelware.exceptions.ServiceException;
import br.com.zup.middleware.configuration.MiddlewareConfiguration;
import br.com.zup.middleware.service.DomainService;
import br.com.zup.middleware.test.AbstractTest;
import br.com.zup.model.entities.Domain;
import br.com.zup.model.entities.Field;
import br.com.zup.model.entities.enums.FieldType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MiddlewareConfiguration.class })
@Transactional
public class DomainServiceTest extends AbstractTest {

	@Autowired
	private DomainService domainService;

	private Domain domain = null;

	@Test
	@Rollback(false)
	public void testSave() {

		domain = buildDomainObject();
		try {
			domainService.save(domain);
			Assert.assertNotNull(domain.getId());
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	@Rollback(false)
	public void TestUpdate() {

		try {

			domain = getPersistedDomain();
			if (domain != null) {

				for (Field field : domain.getFields()) {
					field.setName(field.getName() + " update");
				}

				domain.setName("Product update");
				Field f3 = new Field();
				f3.setName("Unidade");
				f3.setType(FieldType.INT);
				f3.setDomain(domain);
				domain.getFields().add(f3);

				domainService.update(domain);
			} else {
				Assert.assertNull(domain);
			}

		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

	@Test
	@Rollback(false)
	public void testDelete() {

		try {

			domain = getPersistedDomain();

			if (domain != null) {

				domainService.delete(domain);
				Assert.assertNotNull(domain);
			} else {
				Assert.assertNull(domain);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	private Domain getPersistedDomain() throws ServiceException {

		List<Domain> result = domainService.findByExample(buildDomainFilter());
		return (result != null && result.size() > 0) ? result.get(0) : null;
	}

}
