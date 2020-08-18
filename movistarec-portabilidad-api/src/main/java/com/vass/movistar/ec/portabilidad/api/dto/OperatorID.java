package com.vass.movistar.ec.portabilidad.api.dto;

public class OperatorID {

	private String IdOperator;
	private String Name;
	
	public OperatorID() {
		this.IdOperator = "";
		this.Name = "";
	}

	public OperatorID(String idOperator, String name) {
		super();
		this.IdOperator = idOperator;
		this.Name = name;
	}
	
	public String getIdOperator() {
		return IdOperator;
	}
	public void setIdOperator(String idOperator) {
		IdOperator = idOperator;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
}
