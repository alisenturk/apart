package com.apart.model.debt;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat
public enum DebtCategory {
	
	DUES("DUES","Aidat"),
	FUEL("FUEL","Yakıt"),
	STOCK("STOCK","Demirbaş"),
	MAINTENANCE("MAINTENANCE","Bakım");
	
	
	private String	code;
	private String	label;
	
	DebtCategory(String code, String label) {
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
