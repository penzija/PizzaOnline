package com.example.pizzaonline.repositories;

import com.example.pizzaonline.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    Pizza findByName(String name);
}
