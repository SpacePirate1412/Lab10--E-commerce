package Lib;

public class InsuranceDecorator extends ShipmentDecorator {
    private final Order order;
    private static final double PERCENTAGE = 0.10;

    public InsuranceDecorator(Shipment wrappedShipment, Order order) {
        super(wrappedShipment);
        this.order = order;
    }

    @Override
    public String getInfo() {
        return wrappedShipment.getInfo() + " + Insurance";
    }

    @Override
    public double getCost() {
        double insuranceCost = order.getTotalPrice() * PERCENTAGE;
        return wrappedShipment.getCost() + insuranceCost;
    }
}