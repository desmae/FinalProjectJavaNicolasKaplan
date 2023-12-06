package org.example;
import java.util.concurrent.BlockingQueue;

public class CoffeeMachine implements Runnable {

    public final String machineName;
    private final BlockingQueue<Order> orderQueue;

    public CoffeeMachine(String machineName, BlockingQueue<Order> orderQueue) {
        this.machineName = machineName;
        this.orderQueue = orderQueue;
    }

    @Override
    public void run() {
        brewCoffee();
    }

    private void brewCoffee() {
        try {
            while (true) {
                Order order = orderQueue.take();  // Take the order from the shared queue

                // Brew coffee logic based on the coffee type
                switch (order.getCoffeeType()) {
                    case ESPRESSO:
                        Thread.sleep(2000);
                        break;
                    case LATTE:
                        Thread.sleep(3000);
                        break;
                    case MOCHA:
                        Thread.sleep(4000);
                        break;
                }

                System.out.println(Thread.currentThread().getName() + " " +
                        machineName + ": Order id " + order.getId() +
                        " (" + order.getCoffeeType() + ") for " + order.getName() +
                        " is ready for pickup");

                Thread.sleep((long) (Math.random() * 5000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}