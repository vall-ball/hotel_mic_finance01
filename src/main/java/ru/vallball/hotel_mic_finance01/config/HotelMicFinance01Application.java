package ru.vallball.hotel_mic_finance01.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("ru.vallball.hotel_mic_finance01")
@SpringBootApplication
@EntityScan("ru.vallball.hotel_mic_finance01.model")
public class HotelMicFinance01Application {

	public static void main(String[] args) {
		SpringApplication.run(HotelMicFinance01Application.class, args);
	}

}
