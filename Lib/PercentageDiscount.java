package Lib;

public class PercentageDiscount implements DiscountStrategy {
    private final double percent;

    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    @Override
    public double applyDiscount(Order order) {
        double total = order.getTotalPrice();
        return total * (1 - percent / 100.0);
    }
}