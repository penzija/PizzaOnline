package com.example.ordersserver.entities;

import com.example.pizzaonline.entities.Pizza;
import lombok.Data;

@Data
public class RequestWrapper {
    private Pizza pizza;
    private Order order;


}
