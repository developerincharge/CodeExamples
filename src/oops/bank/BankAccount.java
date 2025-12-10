package oops.bank;


// Abstraction (super)
public class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    // Protected method to update balance (for inheritance)
    protected void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    // inheritance
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " to " + accountHolder + "'s account.");
        }
    }

    // polymorphism - default implementation
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from " + accountHolder + "'s account.");
        } else {
            System.out.println("Withdrawal failed for $" + amount);
        }
    }

    public void displayAccountInfo() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Current Balance: $" + balance);
        System.out.println("-------------------");
    }
}
