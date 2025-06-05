package polymorphismchallenge;

public class Car {
    private String description;

    public Car(String description) {
        this.description = description;
    }

    public void startEngine() {
        System.out.println(description + " ..Car -> Engine starting.....>>");
    }


    protected void runEngine() {
        System.out.println(description + " ..Car -> Engine is running.");
    }

    public void drive() {
        System.out.println(description + " ..Car -> Driving..., , type is  " + getClass().getSimpleName());
        runEngine();
    }

    public String getDescription() {
        return description;
    }
}
