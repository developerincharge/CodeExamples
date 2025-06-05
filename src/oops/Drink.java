package oops;

public class Drink {

    private final String type;
    private final String size;

    public Drink(String type, String size) {
        this.type = type;
        this.size = size;
    }

    public double getPrice() {
        return switch (size.toLowerCase()) {
            case "small" -> 1.00;
            case "medium" -> 1.50;
            case "large" -> 2.00;
            default -> 1.00;
        };
    }

    public void printDetails() {
        System.out.printf("Drink: %s (%s) - $%.2f\n", type, size, getPrice());
    }
}
