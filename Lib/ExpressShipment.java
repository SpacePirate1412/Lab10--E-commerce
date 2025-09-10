package Lib;

public class ExpressShipment implements Shipment {
    private static final double COST = 150.0;

    @Override
    public String getInfo() {
        return "Express Delivery";
    }

    @Override
    public double getCost() {
        return COST;
    }
}
