package polymorphismchallenge2;

public class Ford extends Car {

    public Ford(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return getClass().getSimpleName() + " -> startEngine()";
    }

    @Override
    public String accelerate() {
        return getClass().getSimpleName() + " -> accelerate()";
    }

    @Override
    public String brake() {
        return getClass().getSimpleName() + " -> brake()";
    }


    @Override
    public double getTopSpeed() {
        return 220.0; // Ford's specific top speed
    }

    @Override
    public double getFuelEfficiency() {
        return 12.5;
    }
}
