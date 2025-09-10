package Lib;

import java.util.ArrayList;
import java.util.List;

public class OrderProcessor {
    private final List<OrderObserver> observers = new ArrayList<>();

    public void register(OrderObserver observer) {
        observers.add(observer);
    }

    public void unregister(OrderObserver observer) {
        observers.remove(observer);
    }

    public void processOrder(Order order) {
        System.out.println("Processing order " + order.orderId());
        for (OrderObserver o : observers) {
            o.update(order);
        }
    }
}