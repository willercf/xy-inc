package br.com.zup.middleware.test;

import java.util.HashSet;
import java.util.Set;

import br.com.zup.model.entities.Domain;
import br.com.zup.model.entities.Field;
import br.com.zup.model.entities.enums.FieldType;

public abstract class AbstractTest {

	protected Domain buildDomainObject() {

		Domain domain = new Domain();

		domain.setName("Product");
		domain.setMnemonic("product");
		domain.setFields(buildFields(domain));

		return domain;
	}

	protected Domain buildDomainFilter() {

		Domain domain = new Domain();

		domain.setMnemonic("product");
		domain.setFields(buildFields(domain));

		return domain;
	}

	protected Set<Field> buildFields(Domain domain) {

		Set<Field> fields = new HashSet<Field>();

		Field f1 = new Field();
		f1.setName("Nome");
		f1.setType(FieldType.TEXT);
		f1.setDomain(domain);
		fields.add(f1);

		Field f2 = new Field();
		f2.setName("Preço");
		f2.setType(FieldType.DECIMAL);
		f2.setDomain(domain);
		fields.add(f2);

		return fields;
	}

}
