package com.apart.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.apart.model.base.BaseEntity;
import com.apart.model.base.BaseInterface;
import com.apart.model.base.City;

@Entity
@Table(name="apartment")
public class Apartment extends BaseEntity implements BaseInterface{

	private String	name;
	private String	address;
	private City	city;
	private County	county;
	
	private List<Flat> flats = new ArrayList<>();
	
	@Column(length=60,nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(length=256,nullable=false)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.PERSIST)
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	public County getCounty() {
		return county;
	}
	public void setCounty(County county) {
		this.county = county;
	}
	
	@OneToMany(mappedBy="apartment")
	public List<Flat> getFlats() {
		return flats;
	}
	public void setFlats(List<Flat> flats) {
		this.flats = flats;
	}
	
	
}
