package platform.common.base.core.exception;

import org.springframework.http.HttpStatus;

public class ServiceException extends RuntimeException {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private String message;
	private HttpStatus status;

	public ServiceException(HttpStatus status, Throwable throwable) {
		this.status = status;
	}

	public ServiceException(HttpStatus status, Throwable throwable, String message) {
		this.status = status;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
