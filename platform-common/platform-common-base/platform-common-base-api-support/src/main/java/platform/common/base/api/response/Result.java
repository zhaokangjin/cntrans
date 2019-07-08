package platform.common.base.api.response;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class Result<T> implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -2965699607118335116L;

	private HttpStatus status;
	private T result;
	private String i18n;

	public Result() {
	}
	public Result(HttpStatus status, T result) {
		this.status = status;
		this.result = result;
	}

	public Result(HttpStatus status, T result, String i18n) {
		this.status = status;
		this.result = result;
		this.i18n = i18n;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public String getI18n() {
		return i18n;
	}

	public void setI18n(String i18n) {
		this.i18n = i18n;
	}

}
