package Lib;

public class StandardShipment implements Shipment {
    private static final double COST = 50.0;

    @Override
    public String getInfo() {
        return "Standard Delivery";
    }

    @Override
    public double getCost() {
        return COST;
    }
}