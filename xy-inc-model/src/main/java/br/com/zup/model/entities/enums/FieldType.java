package br.com.zup.model.entities.enums;

public enum FieldType {

	INT("Inteiro"), TEXT("Texto"), DATE("Data"), DECIMAL("Decimal");

	private String description;

	private FieldType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public static FieldType getFieldTypeByOrdinal(int ordinal) {

		for (FieldType item : values()) {
			if (item.ordinal() == ordinal) {
				return item;
			}
		}

		return null;
	}

}
