package com.vass.movistar.ec.portabilidad.api.dto;

import java.util.Map;

public class ResponsePinStatus {

	private String status;
	private String message;
	private boolean pinValid;

	private String json;
	private Map<String, String> errors;

	public ResponsePinStatus() {
		this.status = "";
		this.message = "";
		this.pinValid = false;
		this.errors = null;
	}

	public ResponsePinStatus(String status, String message, boolean pinValid, String inquiryId,
			Map<String, String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.pinValid = pinValid;
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

	public boolean getPinValid() {
		return pinValid;
	}

	public void setPinValid(boolean pinValid) {
		this.pinValid = pinValid;
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
		return "ResponsePinStatus [status=" + status + ", message=" + message + ", pinValid=" + pinValid + "]";
	}

}
