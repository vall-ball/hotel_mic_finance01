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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.vallball.hotel_mic_admin01.model.Booking;
import ru.vallball.hotel_mic_admin01.model.User;
import ru.vallball.hotel_mic_admin01.service.BookingService;
import ru.vallball.hotel_mic_admin01.service.UserService;

@RestController
@RequestMapping(value = "/bookings")
public class BookingRestController {
	private static final Logger logger = LoggerFactory.getLogger(BookingRestController.class);

	@Autowired
	BookingService bookingService;
	
	@Autowired
	UserService userService;

	@GetMapping
	public List<Booking> list() {
		return bookingService.list();
	}
	@GetMapping("/test")
	public void test() {
		System.out.println("______________TEST_________");
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> get(@PathVariable(value = "id") Long id) {
		try {
			Booking booking = bookingService.findById(id);
			return new ResponseEntity<>(booking, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("The booking not found", HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping
	public ResponseEntity<Object> create(@Valid @RequestBody Booking booking) {
		if (booking.getClient() == null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User client = userService.findUserByUsername(auth.getName());
			booking.setClient(client);
		}
		bookingService.save(booking);
		return new ResponseEntity<>("The booking is created successfully", HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody Booking booking) {
		try {
			Booking bookingForUpdate = bookingService.findById(id);
			bookingForUpdate.setClient(booking.getClient());
			bookingForUpdate.setStart(booking.getStart());
			bookingForUpdate.setEnd(booking.getEnd());
			bookingForUpdate.setRoom(booking.getRoom());
			bookingService.save(bookingForUpdate);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("The booking not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("The booking is udated successfully", HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
		try {
			bookingService.delete(id);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>("The booking not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("The booking is deleted successfully", HttpStatus.ACCEPTED);
	}

}
