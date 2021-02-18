package ru.vallball.hotel_mic_admin01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vallball.hotel_mic_admin01.dao.BookingRepository;
import ru.vallball.hotel_mic_admin01.model.Booking;

@Service
@Transactional
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	BookingRepository bookingRepository;

	@Override
	public void save(Booking booking) {
		bookingRepository.save(booking);
	}

	@Override
	public List<Booking> list() {
		return bookingRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		bookingRepository.deleteById(id);
	}

	@Override
	public Booking findById(Long id) {
		return bookingRepository.findById(id).get();
	}

}

