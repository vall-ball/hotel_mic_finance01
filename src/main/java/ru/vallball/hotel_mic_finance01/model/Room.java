package ru.vallball.hotel_mic_finance01.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class Room {

	private Long id;

	private int number;
	
	private int floor;

	@JsonBackReference
	private Hotel hotel;
	
	private Integer price;

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "the room " + this.number + " in " + this.getHotel().getName() + " on the " + this.floor + " floor";
	}
	
}
