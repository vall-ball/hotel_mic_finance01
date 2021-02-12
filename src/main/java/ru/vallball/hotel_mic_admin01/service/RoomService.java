package ru.vallball.hotel_mic_admin01.service;

import java.util.List;

import ru.vallball.hotel_mic_admin01.model.Room;

public interface RoomService {

	void save(Room room);

	List<Room> list();

	void delete(Long id);

	Room findRoomById(Long id);
}
