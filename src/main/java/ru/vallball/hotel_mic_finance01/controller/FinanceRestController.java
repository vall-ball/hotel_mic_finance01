package ru.vallball.hotel_mic_finance01.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import ru.vallball.hotel_mic_finance01.model.Booking;
import ru.vallball.hotel_mic_finance01.model.Room;

@RestController
@RequestMapping(value = "/finance")
public class FinanceRestController {
	
	private final WebClient webClient;
	
	public FinanceRestController(WebClient.Builder webClientBuilder) {
		System.out.println("public FinanceRestController(WebClient.Builder webClientBuilder)");
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }
	
	@GetMapping
	public void get() {
		System.out.println("@GetMapping(\"/{id}\")\r\n");
	}
	
	@GetMapping("/{id}")
	public void getFinance(@PathVariable(value = "id") Long id) {
		Mono<List> response = webClient.get().uri("/hotels/bookings/" + id)
				  .accept(MediaType.APPLICATION_JSON)
				  .retrieve()
				  .bodyToMono(new ParameterizedTypeReference<List>() {});
				List readers = response.block();
				System.out.println(readers);
		/*System.out.println("@GetMapping" + id);
		webClient.get().uri("/hotels/booking/" + id).accept(MediaType.APPLICATION_JSON).retrieve()
		
/*		
				accept(MediaType.APPLICATION_JSON)
			     .retrieve()
			     .bodyToFlux(Booking.class)
                 .collectList();
		System.out.println(list.block());*/
	
	}

}
