package oops;

public class SideItem {
    private final String type;
    private final double price;

    public SideItem(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void printDetails() {
        System.out.println(type + ": $" + price);
    }
}
