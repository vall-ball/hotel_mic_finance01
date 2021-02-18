package ru.vallball.hotel_mic_admin01.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import ru.vallball.hotel_mic_admin01.controller.BookingRestController;

@ComponentScan("ru.vallball.hotel_mic_admin01")
@EnableJpaRepositories("ru.vallball.hotel_mic_admin01.dao")
@EntityScan("ru.vallball.hotel_mic_admin01.model")
@SpringBootApplication
public class HotelMicAdmin01Application {
	private static final Logger logger = LoggerFactory.getLogger(HotelMicAdmin01Application.class);
	public static void main(String[] args) {
		SpringApplication.run(HotelMicAdmin01Application.class, args);
	}

}
