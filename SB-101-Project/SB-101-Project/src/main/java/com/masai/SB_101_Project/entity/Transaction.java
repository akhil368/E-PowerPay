package com.masai.SB_101_Project.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int TransactionId;

	private double amountPaid;
	private LocalDate paymentDate;
	private String paymentMethod;
	
	@ManyToOne
    @JoinColumn(name = "consumer_id")
	private Customer consumer;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Transaction [TransactionId=" + TransactionId + ", amountPaid=" + amountPaid + ", paymentDate="
				+ paymentDate + ", paymentMethod=" + paymentMethod + ", consumer=" + consumer + "]";
	}

	public Transaction(double amountPaid, LocalDate paymentDate, String paymentMethod) {
		super();
		this.amountPaid = amountPaid;
		this.paymentDate = paymentDate;
		this.paymentMethod = paymentMethod;
	}

	public int getTransactionId() {
		return TransactionId;
	}

	public void setTransactionId(int transactionId) {
		TransactionId = transactionId;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Customer getConsumer() {
		return consumer;
	}

	public void setConsumer(Customer consumer) {
		this.consumer = consumer;
	}
	
}
