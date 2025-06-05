package polymorphismchallenge2;

public class Main {
    public static void main(String[] args) {
        Car[] cars = new Car[] {
                new Car(8, "Base car"),
                new Mitsubishi(6, "Outlander VRX 4WD"),
                new Ford(6, "Ford Falcon"),
                new Holden(6, "Holden Commodore"),
                new Tesla(0, "Tesla Model S")
        };

        for (Car car : cars) {
            System.out.println("\n" + car.getName() + ":");
            System.out.println(car.startEngine());
            System.out.println(car.accelerate());
            System.out.println(car.brake());
            System.out.printf("Top Speed: %.1f km/h\n", car.getTopSpeed());
            System.out.printf("Fuel Efficiency: %.1f km/l\n", car.getFuelEfficiency());

            // Tesla-specific check
            if (car instanceof Tesla tesla) {
                System.out.printf("Electric Range: %.1f km per charge\n", tesla.getRangePerCharge());
            }
        }
    }
}
