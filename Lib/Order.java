package Lib;
import java.util.List;

public record Order(String orderId, List<Product> products, String customerEmail){
    public double getTotalPrice() {
        return products.stream().mapToDouble(Product::price).sum();
    }
 }