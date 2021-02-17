package ru.vallball.hotel_mic_admin01.model;

import java.time.LocalDate;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ru.vallball.hotel_mic_admin01.dao.BookingRepository;
import ru.vallball.hotel_mic_admin01.dao.RoomRepository;

public class DatesIsFreeValidator implements ConstraintValidator<DatesIsFree, Booking>{
	
	@Autowired
	BookingRepository bookingRepository; 
	
	@Autowired
	RoomRepository roomRepository;

	@Override
	public boolean isValid(Booking value, ConstraintValidatorContext context) {
		System.out.println(value);
		Long roomId = value.getRoom().getId();
		System.out.println("roomId = " + roomId);
		System.out.println(roomRepository.findById(roomId).get());
		System.out.println(roomRepository.getClass());
		Room room = roomRepository.findById(roomId).get();
		System.out.println(room);
		List<Booking> bookings = bookingRepository.findAllByRoom(room);
		System.out.println(bookings == null);
		System.out.println(bookings.size());
		for (Booking b : bookings) {
			System.out.println(b);
			if (!datesNotCrossed(value.getStart(), value.getEnd(), b.getStart(), b.getEnd())) {
				return false;
			}
		}
		System.out.println("Valid passed");
		return true;
	}
	
	public boolean datesNotCrossed(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
		return (start1.isBefore(start2) && end1.isBefore(start2)) || (start1.isAfter(end2) && end1.isAfter(end2)); 
	}

}
