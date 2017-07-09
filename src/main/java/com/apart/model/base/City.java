package com.apart.model.base;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.apart.model.County;

@Entity
public class City extends BaseEntity implements BaseInterface {

	private String	name;
	private String	trafficCode;
	
	private List<County> counties = new ArrayList<>();
	
	@Column(nullable=false,length=60)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(length=10)
	public String getTrafficCode() {
		return trafficCode;
	}
	public void setTrafficCode(String trafficCode) {
		this.trafficCode = trafficCode;
	}
	
	@OneToMany(mappedBy="city")
	public List<County> getCounties() {
		return counties;
	}
	public void setCounties(List<County> counties) {
		this.counties = counties;
	}
	
	
	
}
