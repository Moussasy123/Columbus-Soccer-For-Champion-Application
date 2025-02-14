package Columbus.Futbol.Champion.League.Columbus.Soccer.For.Champion.Application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;

import static reactor.core.publisher.Mono.when;

@ExtendWith(MockitoExtension.class)
public class PostClientTest {


    @Mock
    WebClient client;

    @Mock
    private WebClient.RequestHeadersUriSpec requestHeadersSpec;

    @Mock
    private WebClient.RequestHeadersSpec requestHeadersSpec2;

    private PostClient postClient;

    @BeforeEach
    void setup(){
        postClient = new PostClient(client);
    }

    @Test
    void testFindAllPost(){
        var hello = new Post(1, 1, "We are  ", "the best client there is and noone can stop use");
        var hello2 = new Post(2, 2, "Hello", "Dear World I am confused about the whole thing but we are living and that to god");

        when(client.get()).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.uri("/post")).thenReturn(requestHeadersSpec2)
    }

}
