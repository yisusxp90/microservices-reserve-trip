package com.microservices.booking.model;

import java.io.Serializable;

public class Hotel implements Serializable {

	private Integer hotelId;

	private int category;

	private byte available;

	private String name;

	private double price;

	public Hotel() {
		super();
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public byte getAvailable() {
		return available;
	}

	public void setAvailable(byte available) {
		this.available = available;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}