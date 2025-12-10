package oops.bank;

//Bank Account Controlling each transaction
public class BankMain {
    public static void main(String[] args) {
        // Creating account objects
        BankAccount acc1 = new SavingAccount("Alice", 500);
        BankAccount acc2 = new CheckingAccount("Bob", 500);

        // Display initial account info
        System.out.println("=== Initial Account Status ===");
        acc1.displayAccountInfo();
        acc2.displayAccountInfo();

        // Make deposits
        System.out.println("\n=== Making Deposits ===");
        acc1.deposit(100);
        acc2.deposit(200);

        // Display account info after deposits
        System.out.println("\n=== After Deposits ===");
        acc1.displayAccountInfo();
        acc2.displayAccountInfo();

        // Attempt withdrawals
        System.out.println("\n=== Attempting Withdrawals ===");
        System.out.println("Alice's Saving Account:");
        acc1.withdraw(500);  // Should work (600 available)

        System.out.println("\nBob's Checking Account:");
        acc2.withdraw(700);  // Should work (600 balance + 100 overdraft = 700 limit)

        // Try another withdrawal that should fail
        System.out.println("\n=== Additional Withdrawal Attempt ===");
        System.out.println("Bob's Checking Account:");
        acc2.withdraw(50);  // Should work (currently at -100, so 50 more should be allowed within overdraft)

        // Demonstrate polymorphism with array
        System.out.println("\n=== Demonstrating Polymorphism ===");
        BankAccount[] accounts = {acc1, acc2};

        for (BankAccount account : accounts) {
            System.out.println("\nProcessing " + account.getAccountHolder() + "'s account:");
            System.out.println("Account Type: " + account.getClass().getSimpleName());
            account.displayAccountInfo();
        }
    }
}
