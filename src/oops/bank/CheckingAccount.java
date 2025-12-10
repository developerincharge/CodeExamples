package oops.bank;

// subclass of BankAccount
public class CheckingAccount extends BankAccount{



    private final double overdraftLimit = 100;

    public CheckingAccount(String accountHolder, double balance){
        super(accountHolder, balance);
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    // polymorphism
    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance() + overdraftLimit) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawing $" + amount + " from checking account (with overdraft).");
            System.out.println("New balance: $" + getBalance());
        } else {
            System.out.println("Overdraft Limit exceeded. Cannot withdraw $" + amount);
        }
        System.out.println("-------------------");
    }
}
