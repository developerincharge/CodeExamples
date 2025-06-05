package polymorphismchallenge;

public class Main {
    public static void main(String[] args) {
        Car gasCar = new GasPoweredCar("Ford Mustang", 12.5, 8);
        Car electricCar = new ElectricCar("Tesla Model S", 450.0, 100);
        Car hybridCar = new HybridCar("Toyota Prius", 22.0, 20, 4);
        Car car = new Car("Ferrari 298 GTS");
        runRace(car);
        Car ferrari = new GasPoweredCar("Ferrari 296 GTS", 15.4, 6);
        runRace(ferrari);

        Car tesla = new ElectricCar("Tesla Model 3", 568, 75);
        runRace(tesla);

        Car[] cars = {gasCar, electricCar, hybridCar};

        for (Car car1 : cars) {
            System.out.println("\n--- " + car1.getDescription() + " ---");
            car1.startEngine();
            car1.drive();
        }
    }
    public static void runRace(Car car){
        car.startEngine();
        car.drive();
    }
}
