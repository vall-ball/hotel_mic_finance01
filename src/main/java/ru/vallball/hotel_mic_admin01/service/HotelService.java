package ru.vallball.hotel_mic_admin01.service;

import java.util.List;

import ru.vallball.hotel_mic_admin01.model.Booking;
import ru.vallball.hotel_mic_admin01.model.Hotel;

public interface HotelService {
	
	void save(Hotel hotel);

	List<Hotel> list();

	void delete(Long id);

	Hotel findHotelById(Long id);
	
	List<Booking> listBookingsOfTheHotel(Long id);
}
