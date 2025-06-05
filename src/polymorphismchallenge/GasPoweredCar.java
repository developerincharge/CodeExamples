package polymorphismchallenge;

public class GasPoweredCar extends Car {
    private double avgKmPerLiter;
    private int cylinders = 6;

    public GasPoweredCar(String description){
        super(description);
    }

    public GasPoweredCar(String description, double avgKmPerLitre, int cylinders) {
        super(description);
        this.avgKmPerLiter = avgKmPerLiter;
        this.cylinders = cylinders;
    }

    @Override
    public void startEngine() {

        System.out.println(getDescription() + " Gas  -> Igniting spark plugs and fired up , Ready with " + cylinders + "  cylinders.");
    }

    @Override
    protected void runEngine() {

       // double range = avgKmPerLiter * 50; // Assume 50 liters tank
        System.out.println(getDescription() + " Gas  -> Gas engine running. Average Range:  " + avgKmPerLiter + " km.");
    }
}
