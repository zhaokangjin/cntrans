package platform.common.base.core.exception;

import platform.common.base.core.status.Status;

public class ServiceException extends RuntimeException {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private String message;
	private Status status;

	public ServiceException(Status status, Throwable throwable) {
		this.status = status;
	}

	public ServiceException(Status status, Throwable throwable, String message) {
		this.status = status;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
