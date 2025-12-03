package interfaceandabstract;

abstract class Shape{
    public abstract double calculateArea();
}

class Circle extends Shape{

    public double radius;

    public Circle(double radius) {
         this.radius = radius;

        System.out.println("Area of Circle :  "+calculateArea());
    }

    @Override
    public double calculateArea() {
        return Math.PI*radius*radius;
    }
}

public class AbstractClassDemo {

    public static void main(String[] args) {
        Shape circle = new Circle(5);

        circle.calculateArea();
    }
}
