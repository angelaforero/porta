package com.vass.movistar.ec.portabilidad.api.dto;

import java.util.Map;

public class ResponseManagePortability {
	private String status;
	private String message;
	private boolean isCompleted;
	private String json;
	private Map<String, String> errors;

	public ResponseManagePortability() {
		this.status = "";
		this.message = "";
		this.isCompleted = false;
		this.errors = null;
	}

	public ResponseManagePortability(String status, String message, boolean isCompleted, Map<String, String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.isCompleted = isCompleted;
		this.errors = errors;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	@Override
	public String toString() {
		return "ResponseMovistarCellphone [status=" + status + ", message=" + message + ", isCompleted=" + isCompleted
				+ "]";
	}
}
