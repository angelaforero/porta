package com.vass.movistar.ec.portabilidad.api.dto;

import java.util.Map;

public class ResponseSaveFileFTP {

	private String status;
	private String message;
	private boolean fileSaved;
	private Map<String, String> errors;
	private String json;

	public ResponseSaveFileFTP() {
		this.status = "";
		this.message = "";
		this.fileSaved = false;
		this.errors = null;
	}

	public ResponseSaveFileFTP(String status, String message, boolean fileSaved, Map<String, String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.fileSaved = fileSaved;
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

	public boolean getFileSaved() {
		return fileSaved;
	}

	public void setFileSaved(boolean fileSaved) {
		this.fileSaved = fileSaved;
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
