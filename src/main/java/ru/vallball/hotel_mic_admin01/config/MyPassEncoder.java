package ru.vallball.hotel_mic_admin01.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MyPassEncoder {
	public static void main(String[] args) {
		String password = "123";
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode(password));
	}

}
