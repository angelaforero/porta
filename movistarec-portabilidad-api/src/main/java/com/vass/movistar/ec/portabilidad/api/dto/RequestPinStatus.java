package com.vass.movistar.ec.portabilidad.api.dto;

public class RequestPinStatus {

	private String inquiryId;
	private String cellphone;
	private String pin;

	public String getInquiryId() {
		return inquiryId;
	}

	public void setInquiryId(String inquiryId) {
		this.inquiryId = inquiryId;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public RequestPinStatus() {

		this.inquiryId = "";
		this.cellphone = "";
		this.pin = "";
	}

	public RequestPinStatus(String inquiryId, String cellphone, String pin) {
		this.inquiryId = inquiryId;
		this.cellphone = cellphone;
		this.pin = pin;
	}

}
