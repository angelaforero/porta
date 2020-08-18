package com.vass.movistar.ec.portabilidad.api.dto;

import java.util.Map;

public class ResponseMovistarCellphone {

	private String status;
	private String message;
	private boolean isMovistar;
	private String json;
	private Map<String, String> errors;

	public ResponseMovistarCellphone() {
		this.status = "";
		this.message = "";
		this.isMovistar = false;
		this.errors = null;
	}

	public ResponseMovistarCellphone(String status, String message, boolean isMovistar, Map<String, String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.isMovistar = isMovistar;
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

	public boolean getIsMovistar() {
		return isMovistar;
	}

	public void setIsMovistar(boolean isMovistar) {
		this.isMovistar = isMovistar;
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
		return "ResponseMovistarCellphone [status=" + status + ", message=" + message + ", isMovistar=" + isMovistar
				+ "]";
	}
}
