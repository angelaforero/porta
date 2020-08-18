package com.vass.movistar.ec.portabilidad.api.dto;

public class RequestPinRequest {

	private String cellphone;
	private String idOperator;

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getIdOperator() {
		return idOperator;
	}

	public void setIdOperator(String idOperator) {
		this.idOperator = idOperator;
	}

	public RequestPinRequest() {

		this.cellphone = "";
		this.idOperator = "";
	}

	public RequestPinRequest(String cellphone, String idOperator) {
		this.cellphone = cellphone;
		this.idOperator = idOperator;
	}
}
