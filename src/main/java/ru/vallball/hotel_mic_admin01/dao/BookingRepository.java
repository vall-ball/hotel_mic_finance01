package ru.vallball.hotel_mic_admin01.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vallball.hotel_mic_admin01.model.Booking;

public interface BookingRepository  extends JpaRepository<Booking, Long>{

}
