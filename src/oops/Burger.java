package oops;

import java.util.ArrayList;
import java.util.List;

public class Burger {
    private final String type;
    private final double basePrice;
    private final List<Topping> toppings;

    public Burger(String type, double basePrice) {
        this.type = type;
        this.basePrice = basePrice;
        this.toppings = new ArrayList<>();
    }

    public boolean addTopping(Topping topping) {
        if (toppings.size() < 3) {
            toppings.add(topping);
            return true;
        }
        System.out.println("Max 3 toppings allowed.");
        return false;
    }

    public List<Topping> getToppings() {
        return new ArrayList<>(toppings);
    }

    public double getTotalPrice() {
        return basePrice + toppings.stream().mapToDouble(Topping::getPrice).sum();
    }

    public void printDetails() {
        System.out.printf("Burger: %s ($%.2f)\n", type, basePrice);
        if (toppings.isEmpty()) {
            System.out.println("No extra toppings.");
        } else {
            System.out.println("Toppings:");
            for (Topping t : toppings) {
                System.out.printf("  - %s\n", t);
            }
        }
        System.out.printf("Burger Subtotal: $%.2f\n", getTotalPrice());
    }
}
