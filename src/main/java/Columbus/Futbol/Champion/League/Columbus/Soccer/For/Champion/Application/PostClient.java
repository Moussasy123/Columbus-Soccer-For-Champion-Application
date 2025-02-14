package Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class PostClient {

   private final  WebClient webClient;

    public PostClient(WebClient webClient) {
         this.webClient = webClient;
    }

    public Flux<Post> findAll(){
        return webClient.get()
                .uri("/posts")
                .retrieve()
                .bodyToFlux(Post.class);


    }


}
