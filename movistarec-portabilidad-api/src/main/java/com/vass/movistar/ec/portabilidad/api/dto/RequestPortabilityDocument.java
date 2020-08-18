package com.vass.movistar.ec.portabilidad.api.dto;

public class RequestPortabilityDocument {

	public String fullName;
	public String currentPlan;
	public String futurePlan;
	public String operator;
	public String nip;
	public String cellphone;
	public String document;
	public String base64Signature;

	public String getFullName() {
		return fullName;
	}

	public void setFullname(String fullName) {
		this.fullName = fullName;
	}

	public String getCurrentPlan() {
		return currentPlan;
	}

	public void setCurrentPlan(String currentPlan) {
		this.currentPlan = currentPlan;
	}

	public String getFuturePlan() {
		return futurePlan;
	}

	public void setFuturePlan(String futurePlan) {
		this.futurePlan = futurePlan;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getNIP() {
		return nip;
	}

	public void setNIP(String nip) {
		this.nip = nip;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getBase64Signature() {
		return base64Signature;
	}

	public void setBase64Signature(String base64Signature) {
		this.base64Signature = base64Signature;
	}

	public RequestPortabilityDocument() {
		this.fullName = "";
		this.currentPlan = "";
		this.futurePlan = "";
		this.operator = "";
		this.nip = "";
		this.cellphone = "";
		this.document = "";
		this.base64Signature = "";
	}

	public RequestPortabilityDocument(String fullName, String currentPlan, String futurePlan, String operator,
			String nip, String cellphone, String document, String base64Signature) {
		this.fullName = fullName;
		this.currentPlan = currentPlan;
		this.futurePlan = futurePlan;
		this.operator = operator;
		this.nip = nip;
		this.cellphone = cellphone;
		this.document = document;
		this.base64Signature = base64Signature;
	}

}
