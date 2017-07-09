package com.apart.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.apart.model.base.BaseEntity;
import com.apart.model.base.BaseInterface;
import com.apart.model.base.City;

@Entity
public class County extends BaseEntity implements BaseInterface {
	
	private City	city;
	private String	name;
	
	@ManyToOne
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
