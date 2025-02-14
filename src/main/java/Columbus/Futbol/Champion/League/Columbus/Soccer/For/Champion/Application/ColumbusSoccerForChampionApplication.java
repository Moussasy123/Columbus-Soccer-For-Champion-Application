package Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class ColumbusSoccerForChampionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColumbusSoccerForChampionApplication.class, args);
	}

	@Bean
	WebClient webClient(WebClient.Builder builder){
		return builder.baseUrl("https://jsonplaceholder.typicode.com").build();
	}

	@Bean
	CommandLineRunner commandLineRunner(PostClient postClient) {
		return args -> {
			Flux<Post> postFlux = postClient.findAll();
			postFlux.subscribe(System.out::println);
		};
	}



}
