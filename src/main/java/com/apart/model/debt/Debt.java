package com.apart.model.debt;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.apart.model.Flat;
import com.apart.model.base.BaseEntity;
import com.apart.model.base.BaseInterface;

@Entity
public class Debt extends BaseEntity implements BaseInterface{

	private Flat			flat;
	private String			debitor;
	private DebtType		debtType;
	private DebtCategory	category;
	private	double			amount;
	private Date			expiryDate;
	private DebtStatus		debtStatus;
	private double			paidAmount;
	private String			description;
	
	@ManyToOne
	public Flat getFlat() {
		return flat;
	}
	public void setFlat(Flat flat) {
		this.flat = flat;
	}
	
	@Column(nullable=false,length=60)
	public String getDebitor() {
		return debitor;
	}
	public void setDebitor(String debitor) {
		this.debitor = debitor;
	}
	
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	public DebtType getDebtType() {
		return debtType;
	}
	public void setDebtType(DebtType debtType) {
		this.debtType = debtType;
	}
	
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	public DebtCategory getCategory() {
		return category;
	}
	public void setCategory(DebtCategory category) {
		this.category = category;
	}
	
	@Min(value=1)
	@Max(value=999999)
	@Column(nullable=false)
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	@Column(nullable=false)
	@Enumerated
	public DebtStatus getDebtStatus() {
		return debtStatus;
	}
	public void setDebtStatus(DebtStatus debtStatus) {
		this.debtStatus = debtStatus;
	}
	public double getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
