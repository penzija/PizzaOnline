package com.example.ordersserver.controllers;

import com.example.ordersserver.entities.Order;
import com.example.ordersserver.entities.RequestWrapper;
import com.example.ordersserver.repositories.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping("/orders")
    public ResponseEntity updateOrderWithPizzaName
            (@RequestBody RequestWrapper requestWrapper) throws URISyntaxException {

        String foundPizzaName = requestWrapper.getPizza().getName();
        String foundNameOfPerson = requestWrapper.getOrder().getNameOfPerson();

        Order savedOrder = orderRepository.save(requestWrapper.getOrder());
        URI orderUri = new URI("/orders/" + savedOrder.getId());
        return ResponseEntity.created(orderUri).build();


    }


    @GetMapping("/orders")
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/orders/{id}")
    public Optional<Order> findById(@PathVariable("id") Long id) {
        return orderRepository.findById(id);
    }
}
