package polymorphismchallenge2;

public class Tesla extends Car {
    public Tesla(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return getClass().getSimpleName() + " -> powerOn() (Electric Start)";
    }

    @Override
    public String accelerate() {
        return getClass().getSimpleName() + " -> silent accelerate()";
    }

    @Override
    public String brake() {
        return getClass().getSimpleName() + " -> regenerative brake()";
    }

    @Override
    public double getTopSpeed() {
        return 250.0;
    }

    @Override
    public double getFuelEfficiency() {
        return 0.0; // Not applicable in L/km
    }

    public double getRangePerCharge() {
        return 520.0; // Additional Tesla-specific method
    }
}
