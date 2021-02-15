package ru.vallball.hotel_mic_admin01.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ru.vallball.hotel_mic_admin01.model.Hotel;
import ru.vallball.hotel_mic_admin01.model.Room;
import ru.vallball.hotel_mic_admin01.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomRestController {

	@Autowired
	RoomService roomService;

	@GetMapping
	@ResponseBody
	public List<Room> list() {
		return roomService.list();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> get(@PathVariable(value = "id") Long id) {
		try {
			Room room = roomService.findRoomById(id);
			return new ResponseEntity<>(room, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("The room not found", HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping
	public ResponseEntity<Object> create(@Valid @RequestBody Room room) {
		roomService.save(room);
		return new ResponseEntity<>("The room is created successfully", HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody Room room) {
		try {
			Room roomForUpdate = roomService.findRoomById(id);
			roomForUpdate.setFloor(room.getFloor());
			roomForUpdate.setHotel(room.getHotel());
			roomForUpdate.setNumber(room.getNumber());
			roomForUpdate.setPrice(room.getPrice());
			roomService.save(roomForUpdate);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("The room not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("The room is udated successfully", HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") Long id) {
		try {
			roomService.delete(id);
		} catch (EmptyResultDataAccessException e) {
			return new ResponseEntity<>("The room not found", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("The room is deleted successfully", HttpStatus.ACCEPTED);
	}
	
}
