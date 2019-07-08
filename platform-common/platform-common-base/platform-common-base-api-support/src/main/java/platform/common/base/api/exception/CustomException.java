package platform.common.base.api.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends Throwable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private String i18n;
	private HttpStatus status;

	public CustomException(HttpStatus status, Throwable throwable) {
		this.status = status;
	}

	public CustomException(HttpStatus status, Throwable throwable, String i18n) {
		this.status = status;
		this.i18n = i18n;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getI18n() {
		return i18n;
	}

	public void setI18n(String i18n) {
		this.i18n = i18n;
	}

}
