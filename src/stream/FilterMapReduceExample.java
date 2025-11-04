package stream;

import java.util.Arrays;
import java.util.List;
       //   Complex object processing
class Product {
    private String name;
    private double price;
    private String category;
    
    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
}

public class FilterMapReduceExample {
    public static void main(String[] args) {
        // Examples of combining filter + map + reduce in a single stream pipeline
        System.out.println("########  Complex object processing  ########");
        List<Product> products = Arrays.asList(
            new Product("Laptop", 999.99, "Electronics"),
            new Product("Phone", 699.99, "Electronics"),
            new Product("Book", 19.99, "Education"),
            new Product("Tablet", 399.99, "Electronics"),
            new Product("Pen", 1.99, "Stationery")
        );
        
        // Filter Electronics -> Map to discounted price -> Reduce to total cost
        double totalDiscountedCost = products.stream()
                .filter(p -> "Electronics".equals(p.getCategory()))  // Only electronics
                .map(p -> p.getPrice() * 0.9)                        // Apply 10% discount
                .reduce(0.0, Double::sum);                           // Sum all prices
        
        System.out.printf("Total discounted cost of electronics: $%.2f%n", totalDiscountedCost);
        // Calculation: (999.99*0.9) + (699.99*0.9) + (399.99*0.9) = 899.99 + 629.99 + 359.99 = 1889.97
    }
}