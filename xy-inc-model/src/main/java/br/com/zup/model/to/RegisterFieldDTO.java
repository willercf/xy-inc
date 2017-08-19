package br.com.zup.model.to;

import java.io.Serializable;

public class RegisterFieldDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private RegisterDomainDTO registerDomain;

	private FieldDTO field;

	private String value;

	public RegisterFieldDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RegisterDomainDTO getRegisterDomain() {
		return registerDomain;
	}

	public void setRegisterDomain(RegisterDomainDTO registerDomain) {
		this.registerDomain = registerDomain;
	}

	public FieldDTO getField() {
		return field;
	}

	public void setField(FieldDTO field) {
		this.field = field;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((field == null) ? 0 : field.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((registerDomain == null) ? 0 : registerDomain.hashCode());
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
		RegisterFieldDTO other = (RegisterFieldDTO) obj;
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (registerDomain == null) {
			if (other.registerDomain != null)
				return false;
		} else if (!registerDomain.equals(other.registerDomain))
			return false;
		return true;
	}
}
