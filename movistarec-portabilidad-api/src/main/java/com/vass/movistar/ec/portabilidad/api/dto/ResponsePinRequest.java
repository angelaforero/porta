package com.vass.movistar.ec.portabilidad.api.dto;

import java.util.Map;

public class ResponsePinRequest {

	private String status;
	private String message;
	private boolean pinSent;
	private String inquiryId;

	private String json;
	private Map<String, String> errors;

	public ResponsePinRequest() {
		this.status = "";
		this.message = "";
		this.pinSent = false;
		this.inquiryId = "";
		this.errors = null;
	}

	public ResponsePinRequest(String status, String message, boolean pinSent, String inquiryId,
			Map<String, String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.pinSent = pinSent;
		this.inquiryId = inquiryId;
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

	public boolean getPinSent() {
		return pinSent;
	}

	public void setPinSent(boolean pinSent) {
		this.pinSent = pinSent;
	}

	public String getInquiryId() {
		return inquiryId;
	}

	public void setInquiryId(String inquiryId) {
		this.inquiryId = inquiryId;
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
		return "ResponsePinRequest [status=" + status + ", message=" + message + ", pinSent=" + pinSent + ", inquiryId="
				+ inquiryId + "]";
	}

}
