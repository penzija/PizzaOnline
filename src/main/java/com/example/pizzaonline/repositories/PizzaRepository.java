package com.example.pizzaonline.repositories;

import com.example.pizzaonline.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
    Pizza findByName(String name);
}
