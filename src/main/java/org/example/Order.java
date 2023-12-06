package org.example;

import java.util.UUID;

public class Order {

    private String id;
    private String name;
    private CoffeeType coffeeType;

    public Order(String name, CoffeeType coffeeType) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.coffeeType = coffeeType;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }
}