package com.example.pizzaonline;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PizzaOnlineApplicationTests {

    @LocalServerPort
    private int port;

    @Test
    void getPizzaReturnsListOfPizzas(){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:"+port+"/pizzas"))
                //.method("POST", HttpResponse.BodyHandlers.ofString())
                .build();

        var response = client.sendAsync(request, HttpResponse.BodyHandlers
                .ofString()).join();

        assertThat(response.statusCode()).isEqualTo(200);
    }

    @Test
    void contextLoads() {
    }

}
