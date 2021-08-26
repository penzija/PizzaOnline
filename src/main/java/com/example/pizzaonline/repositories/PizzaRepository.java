package com.example.pizzaonline.repositories;

import com.example.pizzaonline.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    @Query("select p from Pizza p where p.name = ?1")
    Pizza findByName(String name);
}
