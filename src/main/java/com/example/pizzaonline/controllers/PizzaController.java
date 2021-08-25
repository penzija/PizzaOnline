package com.example.pizzaonline.controllers;

import com.example.pizzaonline.dto.PizzaDto;
import com.example.pizzaonline.entities.Pizza;
import com.example.pizzaonline.mappers.PizzaMapper;
import com.example.pizzaonline.repositories.PizzaRepository;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

@RestController
public class PizzaController {

    private final PizzaRepository pizzaRepository;
    private final ModelMapper mapper = new ModelMapper();

    public PizzaController(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @GetMapping("/pizzas")
    public List<Pizza> findAllPizzas() {
        return pizzaRepository.findAll();
    }

    @GetMapping("/pizzas/{id}")
    Optional<Pizza> findById(@PathVariable("id") Long id) {
        return pizzaRepository.findById(id);
    }

    @GetMapping("/findapizza/")
    Pizza findOnePizza(String name) {
        return pizzaRepository.findByName(name);
    }

    @PostMapping("/pizzas")
    PizzaDto savePizza(@RequestBody PizzaDto pizza) {
        return PizzaMapper.entityToDto(pizzaRepository.save(PizzaMapper.dtoToEntity(pizza)));
    }

    @DeleteMapping("/pizzas/{id}")
    void deletePizza(@PathVariable("id") Long id) {
        pizzaRepository.deleteById(id);
    }

    @PutMapping("/pizzas/{id}")
    PizzaDto updatePizza(@RequestBody PizzaDto pizza, Long id) {
        return PizzaMapper.entityToDto(pizzaRepository.save(PizzaMapper.dtoToEntity(pizza)));
    }

    @PatchMapping("/pizzas/{id}/{name}")
    PizzaDto updatePizzaName(@RequestBody PizzaDto pizza, Long id, String name) {

        PizzaMapper.dtoToEntity(pizza).setName(name);
        return PizzaMapper.entityToDto(pizzaRepository.save(PizzaMapper.dtoToEntity(pizza)));
    }
}