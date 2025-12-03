package olymorphismdemo;

class Calculator{
    public int add(int a, int b){
        return a + b;
    }

    public int add(int a, int b, int c){
        return a + b + c;
    }

    public double add(double a, double b){
        return a + b;
    }
}


public class CalculatorChallenge {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        System.out.println(" Total Sum of Two Integers  :  "+calculator.add(2,3));
        System.out.println(" Total Sum of Three Integers  :  "+calculator.add(2,3, 5));
        System.out.println(" Total Sum of Two Double  :  "+calculator.add(5.5,4.5 ));
    }
}
