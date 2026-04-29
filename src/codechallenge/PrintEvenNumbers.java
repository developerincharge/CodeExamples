package codechallenge;

public class PrintEvenNumbers {

    public static void main(String[] args) {

        int n = 100; // Change this value to print even numbers up to a different limit
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 1) {
                continue;
            }
            System.out.println(i);
        }
    }
}
