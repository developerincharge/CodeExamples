package oops.bank;
  // Inheritance,  subclass
public class SavingAccount extends BankAccount {

    public SavingAccount(String accountHolder, double balance){
        super(accountHolder, balance);
    }

      @Override
      public void withdraw(double amount) {
          if (amount <= getBalance()) {
              setBalance(getBalance() - amount);
              System.out.println("Withdrawing $" + amount + " from saving account.");
              System.out.println("New balance: $" + getBalance());
          } else {
              System.out.println("Insufficient funds in saving account.");
              System.out.println("Current balance: $" + getBalance() + ", Attempted withdrawal: $" + amount);
          }
          System.out.println("-------------------");
      }
}
