package com.apart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import com.apart.model.base.BaseEntity;
import com.apart.model.base.BaseInterface;

@Entity
public class Flat extends BaseEntity implements BaseInterface {

	private Apartment	apartment;
	private int			storey;
	private int			doorNo;
	private FlatUseCase	useCase;
	private String		ownerName;
	private String		ownerPhone;
	private String		ownerEmail;
	private String		holderName;
	private String		holderPhone;
	private String		holderEmail;
	
	
	@ManyToOne 
	public Apartment getApartment() {
		return apartment;
	}
	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}
	
	@Column(nullable=false)
	public int getStorey() {
		return storey;
	}
	public void setStorey(int storey) {
		this.storey = storey;
	}
	
	@Column(nullable=false)
	public int getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(int doorNo) {
		this.doorNo = doorNo;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	public FlatUseCase getUseCase() {
		return useCase;
	}
	public void setUseCase(FlatUseCase useCase) {
		this.useCase = useCase;
	}
	
	@Column(nullable=false,length=60)
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	@Column(nullable=false,length=20)
	public String getOwnerPhone() {
		return ownerPhone;
	}
	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}
	@Column(nullable=true,length=120)
	public String getOwnerEmail() {
		return ownerEmail;
	}
	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
	
	@Column(nullable=false,length=60)
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	
	@Column(nullable=false,length=20)
	public String getHolderPhone() {
		return holderPhone;
	}
	public void setHolderPhone(String holderPhone) {
		this.holderPhone = holderPhone;
	}
	
	@Column(nullable=true,length=120)
	public String getHolderEmail() {
		return holderEmail;
	}
	public void setHolderEmail(String holderEmail) {
		this.holderEmail = holderEmail;
	}

	
	
	
}
