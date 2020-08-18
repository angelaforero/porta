package com.vass.movistar.ec.portabilidad.api.dto;

public class RequestMergedDocument {

	public String fullName;
	public String pathPDF1;
	public String pathPDF2;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPathPDF1() {
		return pathPDF1;
	}
	public void setPathPDF1(String pathPDF1) {
		this.pathPDF1 = pathPDF1;
	}
	public String getPathPDF2() {
		return pathPDF2;
	}
	public void setPathPDF2(String pathPDF2) {
		this.pathPDF2 = pathPDF2;
	}
	
	public RequestMergedDocument() {
		this.fullName = "";
		this.pathPDF1 = null;
		this.pathPDF2 = null;
	}

	public RequestMergedDocument(String fullName, String pathPDF1, String pathPDF2) {
		this.fullName = fullName;
		this.pathPDF1 = pathPDF1;
		this.pathPDF2 = pathPDF2;
	}
	
}
