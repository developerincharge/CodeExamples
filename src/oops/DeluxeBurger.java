package oops;

public class DeluxeBurger extends Burger {

    public DeluxeBurger() {
        super("Deluxe", 12.99);
    }

    @Override
    public boolean addTopping(Topping topping) {
        return true; // Accepts toppings but doesn't add price
    }

    @Override
    public double getTotalPrice() {
        return 12.99;
    }

    @Override
    public void printDetails() {
        System.out.println("Burger: Deluxe Burger (Fixed Price: $12.99)");
        System.out.println("Includes 5 deluxe toppings (no extra charge)");
        System.out.printf("Burger Subtotal: $%.2f\n", getTotalPrice());
    }
}
