package br.com.zup.model.to;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import br.com.zup.model.entities.Domain;
import br.com.zup.model.entities.Field;

public class DomainDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

	private String mnemonic;

	private Set<FieldDTO> fields;

	public DomainDTO() {
		super();
	}

	public DomainDTO(Domain domain) {

		this.id = domain.getId();
		this.name = domain.getName();
		this.mnemonic = domain.getMnemonic();
		this.fields = new HashSet<FieldDTO>();
		FieldDTO dto = null;
		for (Field field : domain.getFields()) {

			dto = new FieldDTO();
			dto.setId(field.getId());
			dto.setName(field.getName());
			dto.setType(field.getType());
			fields.add(dto);
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMnemonic() {
		return mnemonic;
	}

	public void setMnemonic(String mnemonic) {
		this.mnemonic = mnemonic;
	}

	public Set<FieldDTO> getFields() {
		return fields;
	}

	public void setFields(Set<FieldDTO> fields) {
		this.fields = fields;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DomainDTO other = (DomainDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
