package Lib;

public class InventoryService implements OrderObserver {
    @Override
    public void update(Order order) {
        System.out.println("Inventory updated for order " + order.orderId());
    }
}
