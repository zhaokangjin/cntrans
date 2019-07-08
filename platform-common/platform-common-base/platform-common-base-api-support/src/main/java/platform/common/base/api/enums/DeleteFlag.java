package platform.common.base.api.enums;

public enum DeleteFlag {

	ACTIVE("A"), HARD("H"), SOFT("S");
	private DeleteFlag(String type) {
		setType(type);
	}

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
