package Lib;

public class ShipmentFactory {
    public Shipment createShipment(String type) {
        if (type == null) {
            return new StandardShipment();
        } else if ("EXPRESS".equalsIgnoreCase(type)) {
            return new ExpressShipment();
        } else if ("STANDARD".equalsIgnoreCase(type)) {
            return new StandardShipment();
        } else {
            
            return new StandardShipment();
        }
    }
}
