package com.apart.model.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape=Shape.OBJECT)
public enum UserType {
	ADMIN("ADMIN","Yönetici"),
	RESIDENT("RESIDENT","Bina Sakini");
	
	private String	code;
	private String	label;
	
	UserType(String code,String label){
		this.code = code;
		this.label = label;
	}

	public String getCode() {
		return code;
	}

	public String getLabel() {
		return label;
	}
	

	
}
