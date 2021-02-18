package ru.vallball.hotel_mic_admin01.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "bookings")
@DateValid
@DatesIsFree
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "room_id")
	@NotNull
	private Room room;

	@ManyToOne
	private User client;

	@NotNull
	//@JsonFormat(pattern = "YYYY-MM-dd")
	private LocalDate start;
	
	@NotNull
	//@JsonFormat(pattern = "YYYY-MM-dd")
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
