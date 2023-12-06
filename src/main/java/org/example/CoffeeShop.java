package org.example;

import java.util.concurrent.*;

public class CoffeeShop {
    public static void main(String[] args) {
        final int numberOfCashiers = 2;
        final int numberOfMachines = 4;
        final int threadCount = 10;

        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        BlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

        for (int i = 0; i < numberOfMachines; i++) {
            executorService.submit(new CoffeeMachine("Random name", orderQueue));
        }

        for (int i = 0; i < numberOfCashiers; i++) {
            executorService.submit(new Cashier("Random name", orderQueue));
        }
    }
}