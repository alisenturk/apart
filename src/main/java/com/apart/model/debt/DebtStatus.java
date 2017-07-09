package com.apart.model.debt;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape=Shape.OBJECT)
public enum DebtStatus {
	UNPAID("UNPAID","Ödeme Bekliyor"),
	PAID("PAID","Ödendi");
	
	
	DebtStatus(String code,String label){
		this.code = code;
		this.label = label;
	}
	
	private String 	code;
	private String	label;
	
	public String getCode() {
		return code;
	}
	public String getLabel() {
		return label;
	}
	
	
}
