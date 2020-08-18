package com.vass.movistar.ec.portabilidad.api.dto;

import java.io.File;
import java.util.Map;

public class ResponsePortabilityDocument {

	private String status;
	private String message;
	private File portabilityDocument;
	private Map<String, String> errors;
	private String json;

	public ResponsePortabilityDocument() {
		this.status = "";
		this.message = "";
		this.portabilityDocument = null;
		this.errors = null;
	}

	public ResponsePortabilityDocument(String status, String message, File portabilityDocument,
			Map<String, String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.portabilityDocument = portabilityDocument;
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

	public File getPortabilityDocument() {
		return portabilityDocument;
	}

	public void setPortabilityDocument(File portabilityDocument) {
		this.portabilityDocument = portabilityDocument;
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
