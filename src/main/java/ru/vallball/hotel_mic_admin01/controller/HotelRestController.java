package ru.vallball.hotel_mic_admin01.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ru.vallball.hotel_mic_admin01.dao.BookingRepository;
import ru.vallball.hotel_mic_admin01.dao.RoomRepository;
import ru.vallball.hotel_mic_admin01.model.Hotel;
import ru.vallball.hotel_mic_admin01.service.HotelService;

@RestController
@RequestMapping(value = "/hotels")
public class HotelRestController {
	
	//private static final Logger logger = LoggerFactory.getLogger(HotelRestController.class);

	@Autowired
	HotelService hotelService;
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	RoomRepository roomRepository;
	

	@GetMapping
	public List<Hotel> list() {
		return hotelService.list();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object>  get(@PathVariable(value = "id") Long id) {
		try {
			Hotel hotel = hotelService.findHotelById(id);
			return new ResponseEntity<>(hotel, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("The hotel not found", HttpStatus.NOT_FOUND);
		}

	}
	

	@PostMapping
	public ResponseEntity<Object> create(@Valid @RequestBody Hotel hotel) {
		hotelService.save(hotel);
		return new ResponseEntity<>("The hotel is created successfully", HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody Hotel hotel) {
		try {
			Hotel hotelForUpdate = hotelService.findHotelById(id);
			hotelForUpdate.setCity(hotel.getCity());
			hotelForUpdate.setCountry(hotel.getCountry());
			hotelForUpdate.setName(hotel.getName());
			hotelForUpdate.setRooms(hotel.getRooms());
			hotelService.save(hotelForUpdate);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("The hotel not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("The hotel is udated successfully", HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
		try {
			hotelService.delete(id);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>("The hotel not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("The hotel is deleted successfully", HttpStatus.ACCEPTED);
	}

}
