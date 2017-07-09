package com.apart.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape=Shape.OBJECT)
public enum FlatUseCase {
	OWNER("OWNER","Sahip"),
	HOLDER("HOLDER","Kiracı");
	
	FlatUseCase(String code,String label){
		this.code = code;
		this.label = label;
	}
	
	private String	code;
	private String 	label;
	
	public String getCode() {
		return code;
	}
	public String getLabel() {
		return label;
	}
	
	
}
