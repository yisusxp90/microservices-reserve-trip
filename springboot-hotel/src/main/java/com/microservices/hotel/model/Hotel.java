package com.microservices.hotel.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="hotels")
public class Hotel implements Serializable {

	private static final long serialVersionUID = 6823482517873094074L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int hotelId;

	private int category;

	private byte available;

	private String name;

	private double price;

	public Hotel() {
		super();
	}


	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
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