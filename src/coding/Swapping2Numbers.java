package coding;

public class Swapping2Numbers {

    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        System.out.println("Before Swapping");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        // Swapping logic #1
//        int temp = a;
//        a = b;
//        b = temp;


        // swapping log #2

//        a = a + b;
//        b = a - b;
//        a = a - b;

       // swapping logic #3
//        a = a * b;
//        b = a / b;
//        a = a / b;


        // swapping log #4
//        a = a ^ b;
//        b = a ^ b;
//        a = a ^ b;

        // swapping logic #5

        b = a + b - (a = b);





        System.out.println("After Swapping");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}



