package ru.vallball.hotel_mic_finance01.model;

import java.time.LocalDate;

public class Booking {

	private Long id;

	private Room room;

	private User client;

	private LocalDate start;
	
	private LocalDate end;
	
	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "the booking " + this.id + " in room " + this.getRoom().getId() + " start  " + this.start + " end " + this.end;
	}
	
}
