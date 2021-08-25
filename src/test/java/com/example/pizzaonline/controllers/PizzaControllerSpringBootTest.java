package com.example.pizzaonline.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PizzaControllerSpringBootTest {

    @Autowired
    PizzaController pizzaController;

    @Test
    void getAllPizzas() {
        assertThat(pizzaController.findAllPizzas()).hasSize(1);

    }

}