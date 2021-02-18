package ru.vallball.hotel_mic_admin01.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vallball.hotel_mic_admin01.model.User;

public interface UserRepository extends JpaRepository<User, Long>  {

	User findUserByUsername(String username);
	
}