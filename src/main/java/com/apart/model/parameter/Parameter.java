package com.apart.model.parameter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.apart.model.base.BaseEntity;
import com.apart.model.base.BaseInterface;

@Entity
public class Parameter extends BaseEntity implements BaseInterface{

	private String		paramName;
	private ValueType	valueType;
	private String		paramValue;
	
	
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	
	@Enumerated(EnumType.STRING)
	public ValueType getValueType() {
		return valueType;
	}
	public void setValueType(ValueType valueType) {
		this.valueType = valueType;
	}
	public String getParamValue() {
		return paramValue;
	}
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	
	
	
}
