package polymorphismchallenge;

public class ElectricCar extends Car {
    private double avgKmPerCharge;
    private int batterySize;

    public ElectricCar(String description, double avgKmPerCharge, int batterySize) {
        super(description);
        this.avgKmPerCharge = avgKmPerCharge;
        this.batterySize = batterySize;
    }

    @Override
    public void startEngine() {
        System.out.println(getDescription() + " BEV -> Powering up electric motor. Battery size: " + batterySize + " kWh.");
    }

    @Override
    protected void runEngine() {
        System.out.println(getDescription() + " BEV  -> Electric motor running. Range: " + avgKmPerCharge + " km per charge.");
    }
}
