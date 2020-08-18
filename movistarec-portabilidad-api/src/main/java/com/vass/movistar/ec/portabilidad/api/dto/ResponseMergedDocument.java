package com.vass.movistar.ec.portabilidad.api.dto;

import java.io.File;
import java.util.Map;

public class ResponseMergedDocument {

	private String status;
	private String message;
	private File mergedDocument;
	private Map<String, String> errors;
	private String json;

	public ResponseMergedDocument() {
		this.status = "";
		this.message = "";
		this.mergedDocument = null;
		this.errors = null;
	}

	public ResponseMergedDocument(String status, String message, File mergedDocument, Map<String, String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.mergedDocument = mergedDocument;
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

	public File getMergedDocument() {
		return mergedDocument;
	}

	public void setMergedDocument(File mergedDocument) {
		this.mergedDocument = mergedDocument;
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
