package Lib;

public abstract class ShipmentDecorator implements Shipment {
    protected final Shipment wrappedShipment;

    public ShipmentDecorator(Shipment wrappedShipment) {
        this.wrappedShipment = wrappedShipment;
    }

    @Override
    public String getInfo() {
        return wrappedShipment.getInfo();
    }

    @Override
    public double getCost() {
        return wrappedShipment.getCost();
    }
}