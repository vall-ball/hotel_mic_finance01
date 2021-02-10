package ru.vallball.hotel_mic_admin01.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("ru.vallball.hotel_mic_admin01")
@EnableJpaRepositories("ru.vallball.hotel_mic_admin01.dto")
@EntityScan("ru.vallball.hotel_mic_admin01.model")
@SpringBootApplication
public class HotelMicAdmin01Application {

	public static void main(String[] args) {
		SpringApplication.run(HotelMicAdmin01Application.class, args);
	}

}
