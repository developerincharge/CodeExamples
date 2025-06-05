package oops;

public class Main {
    public static void main(String[] args) {

            // 🍔 Default meal
            Burger defaultBurger = new Burger("Regular", 5.99);
            Meal defaultMeal = new Meal(
                    defaultBurger,
                    new Drink("Coke", "small"),
                    new SideItem("Fries", 1.99)
            );
            defaultMeal.printItemizedBill();

            // 🍔 Custom meal with extra toppings and large drink
            Burger customBurger = new Burger("Cheeseburger", 6.99);
            customBurger.addTopping(new Topping("Lettuce", 0.30));
            customBurger.addTopping(new Topping("Tomato", 0.40));
            customBurger.addTopping(new Topping("Bacon", 1.00));
            Meal customMeal = new Meal(
                    customBurger,
                    new Drink("Pepsi", "large"),
                    new SideItem("Onion Rings", 2.49)
            );
            customMeal.printItemizedBill();

            // 🍔 Deluxe meal with 5 toppings but fixed price
            DeluxeBurger deluxeBurger = new DeluxeBurger();
            deluxeBurger.addTopping(new Topping("Egg", 1.00));
            deluxeBurger.addTopping(new Topping("Avocado", 1.50));
            deluxeBurger.addTopping(new Topping("Mushroom", 0.75));
            deluxeBurger.addTopping(new Topping("Onion", 0.50));
            deluxeBurger.addTopping(new Topping("Pickles", 0.60));
            Meal deluxeMeal = new Meal(
                    deluxeBurger,
                    new Drink("Sprite", "medium"),
                    new SideItem("Curly Fries", 2.29)
            );
            deluxeMeal.printItemizedBill();
        }

}
