package utils;

import java.io.Serializable;

public class HttpResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7676787978230270240L;
	private int code;
	private String message;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
