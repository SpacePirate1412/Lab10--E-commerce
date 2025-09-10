import Lib.*;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //1. ตั้งค่า: สร้าง Product, Order, OrderCalculator, ShipmentFactory, OrderProcessor และ Observer ต่างๆ
        Product p1 = new Product("P001", "T-Shirt", 299.0);
        Product p2 = new Product("P002", "Mug", 149.0);
        Product p3 = new Product("P003", "Sticker", 25.0);
        List<Product> products = List.of(p1, p2, p3);
        Order order = new Order("ORD-1001", products, "customer@example.com");

        //2. คำนวณราคา: ทดลองคำนวณราคาสุดท้ายของ Order โดยใช้ DiscountStrategy ทั้งสองแบบ
        OrderCalculator calculator = new OrderCalculator();
        DiscountStrategy perc10 = new PercentageDiscount(10.0);
        DiscountStrategy fixed100 = new FixedDiscount(100.0);

        double priceAfterPerc = calculator.calculateFinalPrice(order, perc10);
        double priceAfterFixed = calculator.calculateFinalPrice(order, fixed100);

        System.out.printf("Order subtotal: %.2f%n", order.getTotalPrice());
        System.out.printf("After 10%% discount: %.2f%n", priceAfterPerc);
        System.out.printf("After 100 fixed discount: %.2f%n", priceAfterFixed);

        //3. สร้างการจัดส่ง: ใช้ ShipmentFactory เพื่อสร้าง StandardShipment
        ShipmentFactory shipmentFactory = new ShipmentFactory();
        Shipment baseShipment = shipmentFactory.createShipment("STANDARD");

        //4. เพิ่มบริการเสริม: "ห่อ" StandardShipment ที่สร้างขึ้นด้วย GiftWrapDecorator และ InsuranceDecorator
        Shipment giftWrapped = new GiftWrapDecorator(baseShipment);
        Shipment insuredAndGift = new InsuranceDecorator(giftWrapped, order);

        //5. พิมพ์สรุป: แสดงข้อมูลการจัดส่งและค่าใช้จ่ายทั้งหมด (ค่าสินค้าหลังหักส่วนลด + ค่าจัดส่งพร้อมบริการเสริม)
        double finalProductPrice = priceAfterPerc;
        double shipmentCost = insuredAndGift.getCost();
        System.out.println("Shipment info: " + insuredAndGift.getInfo());
        System.out.printf("Shipment cost: %.2f%n", shipmentCost);
        System.out.printf("Grand total: %.2f%n", finalProductPrice + shipmentCost);

        //6. ยืนยันคำสั่งซื้อ: เรียก orderProcessor.processOrder(order) แล้วสังเกตผลลัพธ์ว่า Observer ทั้งสองตัวทำงานหรือไม่
        OrderProcessor processor = new OrderProcessor();
        processor.register(new InventoryService());
        processor.register(new EmailService());
        processor.processOrder(order);
    }
}