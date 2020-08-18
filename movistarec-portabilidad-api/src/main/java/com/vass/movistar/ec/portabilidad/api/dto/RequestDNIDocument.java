package com.vass.movistar.ec.portabilidad.api.dto;

import java.io.File;

public class RequestDNIDocument {

	public String fullName;
	public File dniFront;
	public File dniBack;

	public String getFullName() {
		return fullName;
	}

	public void setFullname(String fullName) {
		this.fullName = fullName;
	}

	public File getDniFront() {
		return dniFront;
	}

	public void setDNIFront(File dniFront) {
		this.dniFront = dniFront;
	}

	public File getDNIBack() {
		return dniBack;
	}

	public void setDniBack(File dniBack) {
		this.dniBack = dniBack;
	}

	public RequestDNIDocument() {
		this.fullName = "";
		this.dniFront = null;
		this.dniBack = null;
	}

	public RequestDNIDocument(String fullName, File dniFront, File dniBack) {
		this.fullName = fullName;
		this.dniFront = dniFront;
		this.dniBack = dniBack;
	}

}
