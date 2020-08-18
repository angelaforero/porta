package com.vass.movistar.ec.portabilidad.api.dto;

import java.util.Map;

public class ResponseSendOBO {

	private String status;
	private String message;
	private Map<String, String> errors;
	private String json;

	public ResponseSendOBO() {
		this.status = "";
		this.message = "";
		this.errors = null;
	}

	public ResponseSendOBO(String status, String message, Map<String, String> errors) {
		super();
		this.status = status;
		this.message = message;
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

}
