package com.vass.movistar.ec.portabilidad.api.dto;

import java.io.File;
import java.util.Map;

public class ResponseDNIDocument {

	private String status;
	private String message;
	private File dniDocument;
	private Map<String, String> errors;
	private String json;

	public ResponseDNIDocument() {
		this.status = "";
		this.message = "";
		this.dniDocument = null;
		this.errors = null;
	}

	public ResponseDNIDocument(String status, String message, File dniDocument, Map<String, String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.dniDocument = dniDocument;
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

	public File getDNIDocument() {
		return dniDocument;
	}

	public void setDNIDocument(File dniDocument) {
		this.dniDocument = dniDocument;
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
