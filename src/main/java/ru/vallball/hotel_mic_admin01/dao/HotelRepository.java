package ru.vallball.hotel_mic_admin01.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vallball.hotel_mic_admin01.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{

}
