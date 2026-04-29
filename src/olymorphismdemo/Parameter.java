package olymorphismdemo;

public class Parameter {
    public static void main(String[] args) {
        //int result = add(5, 10);// calling the method with arguments
        System.out.println("The addition is: " + add(55648546, 69874555));
        System.out.println("The addition is: " + add(25, 65));
        System.out.println("The addition is: " + add(15, 18));
        System.out.println("The addition is: " + add(5, 9));
        System.out.println("The addition is: " + add(-5, 5));
    }
    public static int add(int firstNumber, int secondNumber) { // method with parameters
        System.out.println("Adding " + firstNumber + " and " + secondNumber);
        int sum = firstNumber + secondNumber;
        return sum;
    }
}
