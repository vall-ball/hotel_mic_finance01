package ru.vallball.hotel_mic_admin01.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vallball.hotel_mic_admin01.dao.HotelRepository;
import ru.vallball.hotel_mic_admin01.model.Hotel;

@Service
@Transactional
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	HotelRepository hotelRepository;

	@Override
	public void save(Hotel hotel) {
		hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> list() {
		return hotelRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		hotelRepository.deleteById(id);
	}

	@Override
	public Hotel findHotelById(Long id) {
		return hotelRepository.findById(id).get();
	}

}
