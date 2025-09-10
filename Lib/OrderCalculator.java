package Lib;

public class OrderCalculator {
    public double calculateFinalPrice(Order order, DiscountStrategy strategy) {
        return strategy.applyDiscount(order);
    }
}