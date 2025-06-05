package oops;

public class Meal {

    private final Burger burger;
    private final Drink drink;
    private final SideItem side;

    public Meal(Burger burger, Drink drink, SideItem side) {
        this.burger = burger;
        this.drink = drink;
        this.side = side;
    }

    public double getTotalPrice() {
        return burger.getTotalPrice() + drink.getPrice() + side.getPrice();
    }

    public void printItemizedBill() {
        System.out.println("===== Meal Details =====");
        burger.printDetails();
        drink.printDetails();
        side.printDetails();
        System.out.printf("TOTAL DUE: $%.2f%n", getTotalPrice());
        System.out.println("========================\n");
    }
}
