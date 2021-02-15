package ru.vallball.hotel_mic_admin01.service;

import java.util.List;

import ru.vallball.hotel_mic_admin01.model.Booking;

public interface BookingService {
	
	void save(Booking booking);

	List<Booking> list();

	void delete(Long id);

	Booking findById(Long id);

}
