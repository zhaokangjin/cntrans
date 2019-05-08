package platform.common.base.core.status;

public enum Status {
	SUCCESS(400), EXCEPTION(500);

	private Status(int status) {
		setStatus(status);
	}

	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
