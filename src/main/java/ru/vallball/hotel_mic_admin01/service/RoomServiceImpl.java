package ru.vallball.hotel_mic_admin01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.vallball.hotel_mic_admin01.dto.RoomRepository;
import ru.vallball.hotel_mic_admin01.model.Room;

@Service
@Transactional
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	RoomRepository roomRepository;

	@Override
	public void save(Room room) {
		roomRepository.save(room);
	}

	@Override
	public List<Room> list() {
		return roomRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		roomRepository.deleteById(id);
	}

	@Override
	public Room findRoomById(Long id) {
		return roomRepository.findById(id).get();
	}

}
