package com.example.pizzaonline.controllers;

import org.hibernate.cfg.Environment;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PizzaEndToEndTest {

    @LocalServerPort
    private int port;

    @Test
    void getAllPizzas() {
        HttpClient testClient = HttpClient.newHttpClient();
        HttpRequest testRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:" + port + "/pizzas"))
                .GET().build();

        var response = testClient.sendAsync(testRequest, HttpResponse.BodyHandlers.ofString())
                .join();

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat((response.body())).isEqualTo("[{\"id\":2,\"name\":\"Margherita\"}]");

    }

}