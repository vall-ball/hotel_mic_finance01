package ru.vallball.hotel_mic_admin01.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vallball.hotel_mic_admin01.model.Booking;
import ru.vallball.hotel_mic_admin01.model.Room;

public interface BookingRepository  extends JpaRepository<Booking, Long>{
	
	List<Booking> findAllByRoom(Room room);

}
