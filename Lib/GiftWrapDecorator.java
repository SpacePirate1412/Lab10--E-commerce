package Lib;

public class GiftWrapDecorator extends ShipmentDecorator {
    private static final double GIFTWRAPCOST = 50.0;

    public GiftWrapDecorator(Shipment wrappedShipment) {
        super(wrappedShipment);
    }

    @Override
    public String getInfo() {
        return wrappedShipment.getInfo() + " + Gift Wrapped";
    }

    @Override
    public double getCost() {
        return wrappedShipment.getCost() + GIFTWRAPCOST;
    }
}
