package com.apart.model.debt;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape=Shape.OBJECT)
public enum DebtType {

	DUES("DUES","Aidat"),
	OTHER("OTHER","Diğer");
	
	DebtType(String code,String label) {
		this.code = code;
		this.label = label;
	}
	
	private String	code;
	private String	label;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
