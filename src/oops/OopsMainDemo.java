package oops;

class Car{
    String make;
    String model;
    int year;

    public Car(String make,String model,int year){
        this.make=make;
        this.model=model;
        this.year=year;
    }

    public void displayCarInfo(){
        System.out.println("Car : "+ make+ "  "+ model + "  "+ year);
    }
}



public class OopsMainDemo {

    public static void main(String[] args) {
       Car myCar = new Car("Ford","Mustang",2022);
       myCar.displayCarInfo();
    }
}
