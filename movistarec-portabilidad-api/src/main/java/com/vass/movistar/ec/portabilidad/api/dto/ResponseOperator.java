package com.vass.movistar.ec.portabilidad.api.dto;

import java.util.List;
import java.util.Map;

public class ResponseOperator {
	
	private String status;
	private String message;
	private List<OperatorID> listOperators;
	private String json;
	private Map<String, String> errors;
	
	public ResponseOperator() {
		this.status = "";
		this.message = "";
		this.listOperators = null;
		this.errors = null;
	}

	public ResponseOperator(String status, String message, List<OperatorID> listOperators,
			Map<String, String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.listOperators = listOperators;
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
	public List<OperatorID> getListOperators() {
		return listOperators;
	}
	public void setListOperators(List<OperatorID> listOperators) {
		this.listOperators = listOperators;
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
		return "ResponseOperatorID [status=" + status + ", message=" + message + ", listOperator=" + listOperators + "]";
	}

}
