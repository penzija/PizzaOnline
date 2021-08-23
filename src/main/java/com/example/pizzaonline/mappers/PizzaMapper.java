package com.example.pizzaonline.mappers;

import com.example.pizzaonline.dto.PizzaDto;
import com.example.pizzaonline.entities.Pizza;

public class PizzaMapper {

    public static Pizza dtoToEntity(PizzaDto pizzaDto) {
        return new Pizza(pizzaDto.id, pizzaDto.name);
    }

    public static PizzaDto entityToDto(Pizza pizza) {
        return new PizzaDto(pizza.getId(), pizza.getName());
    }
}
