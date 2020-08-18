package com.vass.movistar.ec.portabilidad.api.dto;

import java.util.Map;

public class ResponseValidDocument {

	private String status;
	private String message;
	private boolean isValid;
	private String json;
	private Map<String, String> errors;

	public ResponseValidDocument() {
		this.status = "";
		this.message = "";
		this.isValid = false;
		this.errors = null;
	}

	public ResponseValidDocument(String status, String message, boolean isValid, Map<String, String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.isValid = isValid;
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

	public boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
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
		return "ResponseValidDocument [status=" + status + ", message=" + message + ", isValid=" + isValid + "]";
	}
}
