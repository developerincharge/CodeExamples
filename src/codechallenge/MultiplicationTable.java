package codechallenge;

public class MultiplicationTable {
    public static void main(String[] args) {
        int n =5;
        printMultiplicationTable(n);
    }

    private static void printMultiplicationTable(int n) {
        // Print the header row
        System.out.print("     ");
        for (int i = 1; i <= n; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println();
        System.out.println("   " + "-".repeat(4 * n));

        // Print the multiplication table
        for (int i = 1; i <= n; i++) {
            // Print the row header
            System.out.printf("%4d |", i);
            for (int j = 1; j <= n; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }

    }
}
