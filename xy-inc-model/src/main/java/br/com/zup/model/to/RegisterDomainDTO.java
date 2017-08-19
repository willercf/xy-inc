package br.com.zup.model.to;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import br.com.zup.model.entities.RegisterDomain;
import br.com.zup.model.entities.RegisterField;

public class RegisterDomainDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private DomainDTO domain;

	private Set<RegisterFieldDTO> registerFields;

	public RegisterDomainDTO() {
		super();
	}

	public RegisterDomainDTO(RegisterDomain registerDomain) {

		this.id = registerDomain.getId();
		this.domain = new DomainDTO(registerDomain.getDomain());
		this.setRegisterFields(new HashSet<RegisterFieldDTO>());
		RegisterFieldDTO rfDto = null;
		for (RegisterField registerField : registerDomain.getRegisterFields()) {

			rfDto = new RegisterFieldDTO();
			rfDto.setId(registerField.getId());
			rfDto.setValue(registerField.getValue());
			this.registerFields.add(rfDto);
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DomainDTO getDomain() {
		return domain;
	}

	public void setDomain(DomainDTO domain) {
		this.domain = domain;
	}

	public Set<RegisterFieldDTO> getRegisterFields() {
		return registerFields;
	}

	public void setRegisterFields(Set<RegisterFieldDTO> registerFields) {
		this.registerFields = registerFields;
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
		RegisterDomainDTO other = (RegisterDomainDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
