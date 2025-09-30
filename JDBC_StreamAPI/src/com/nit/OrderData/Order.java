package com.nit.OrderData;

import java.sql.Date;

public class Order {
	private int id;
	private String name;
	private double amount;
	Date date;
	public Order(int id, String name, double amount, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Id: "+id+
				" Name: "+name+
				" Amount: "+amount+
				" Date: "+date+"\n";
	}
	
}
