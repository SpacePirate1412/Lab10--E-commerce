package Lib;

public class FixedDiscount implements DiscountStrategy {
    private final double amount;

    public FixedDiscount(double amount) {
        this.amount = amount;
    }

    @Override
    public double applyDiscount(Order order) {
        double total = order.getTotalPrice();
        double discounted = total - amount;
        return Math.max(0, discounted);
    }
}