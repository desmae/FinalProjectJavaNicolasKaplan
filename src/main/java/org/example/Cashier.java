package org.example;

import com.github.javafaker.Faker;

import java.util.concurrent.BlockingQueue;

public class Cashier implements Runnable {

    private final String cashierName;
    private final BlockingQueue<Order> orderQueue;

    public Cashier(String cashierName, BlockingQueue<Order> orderQueue) {
        this.cashierName = cashierName;
        this.orderQueue = orderQueue;
    }

    @Override
    public void run() {
        placeOrder();
    }

    private void placeOrder() {
        try {
            while (true) {
                Faker faker = new Faker();
                String customerName = faker.name().fullName();
                CoffeeType coffeeType = CoffeeType.values()[(int) (Math.random() * CoffeeType.values().length)];

                Order order = new Order(customerName, coffeeType);

                System.out.println(Thread.currentThread().getName() + " " +
                        cashierName + ": Order id " + order.getId() +
                        " (" + order.getCoffeeType() + ") is accepted for " + order.getName());

                orderQueue.put(order);  // Put the order into the shared queue

                Thread.sleep((long) (Math.random() * 5000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}