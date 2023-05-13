package com.masai.SB_101_Project.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int billId;
	
//	@Column( nullable = false)
//	private int fixedChargeForConnection;
	
	
	private int unitRate;
	@Column( nullable = false)
	private double totalAmount;
	
	@Column( nullable = false)
	private double prevReading;
	
	@Column( nullable = false)
	private double currReading;
	
	
	private double tax;
//	private double additionalAdjustmentFromCustomer;
//	
//	private double additionalAdjustmentFromCorporation;

	private LocalDate dueDate;

	
	@Column( nullable = false)
	private int isPaid;
	
	@Column(nullable=false)
	private LocalDate startDate;
	
	@Column(nullable =false)
	private LocalDate endDate;
	
	private LocalDate billing_date;
	
	@ManyToOne
  @JoinColumn(name = "consumer_id")
	private Customer consumer;

	public Bill(int unitRate, double totalAmount, double prevReading, double currReading, double tax, LocalDate dueDate,
			int isPaid, LocalDate startDate, LocalDate endDate, LocalDate billing_date) {
		super();
		this.unitRate = unitRate;
		this.totalAmount = totalAmount;
		this.prevReading = prevReading;
		this.currReading = currReading;
		this.tax = tax;
		this.dueDate = dueDate;
		this.isPaid = isPaid;
		this.startDate = startDate;
		this.endDate = endDate;
		this.billing_date = billing_date;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public int getUnitRate() {
		return unitRate;
	}

	public void setUnitRate(int unitRate) {
		this.unitRate = unitRate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getPrevReading() {
		return prevReading;
	}

	public void setPrevReading(double prevReading) {
		this.prevReading = prevReading;
	}

	public double getCurrReading() {
		return currReading;
	}

	public void setCurrReading(double currReading) {
		this.currReading = currReading;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public int getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(int isPaid) {
		this.isPaid = isPaid;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDate getBilling_date() {
		return billing_date;
	}

	public void setBilling_date(LocalDate billing_date) {
		this.billing_date = billing_date;
	}

	public Customer getConsumer() {
		return consumer;
	}

	public void setConsumer(Customer consumer) {
		this.consumer = consumer;
	}

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", unitRate=" + unitRate + ", totalAmount=" + totalAmount + ", prevReading="
				+ prevReading + ", currReading=" + currReading + ", tax=" + tax + ", dueDate=" + dueDate + ", isPaid="
				+ isPaid + ", startDate=" + startDate + ", endDate=" + endDate + ", billing_date=" + billing_date
				+ ", consumer=" + consumer + "]";
	}
	
	
}