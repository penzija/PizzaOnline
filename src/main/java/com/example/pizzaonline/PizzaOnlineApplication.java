package com.example.pizzaonline;

import com.example.pizzaonline.entities.Pizza;
import com.example.pizzaonline.repositories.PizzaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PizzaOnlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzaOnlineApplication.class, args);
    }

    @Bean
    public CommandLineRunner fillDatabase(PizzaRepository pizzaRepository) {
        return args -> {
            if (pizzaRepository.count() == 0) {
                pizzaRepository.save(new Pizza(1L, "Margherita"));
            }
        };
    }
}
