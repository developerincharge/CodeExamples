package polymorphismchallenge;

public class HybridCar extends Car {
    private double avgKmPerLiter;
    private int batterySize;
    private int cylinders;

    public HybridCar(String description, double avgKmPerLiter, int batterySize, int cylinders) {
        super(description);
        this.avgKmPerLiter = avgKmPerLiter;
        this.batterySize = batterySize;
        this.cylinders = cylinders;
    }

    @Override
    public void startEngine() {
        System.out.println(getDescription() + " -> Booting hybrid system: Battery " + batterySize + " kWh and " + cylinders + " cylinders engine.");
    }

    @Override
    protected void runEngine() {
        double gasRange = avgKmPerLiter * 40;
        double electricRange = batterySize * 3.5; // assume 3.5 km per kWh
        System.out.println(getDescription() + " -> Hybrid running. Combined range: " + (gasRange + electricRange) + " km.");
    }
}
