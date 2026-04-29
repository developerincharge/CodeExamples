package com.rizvi.immutable;

import java.util.*;
import java.time.LocalDate;

public final class ImmutableBankAccount {
    private final String accountNumber;
    private final String accountHolder;
    private final double balance;
    private final LocalDate openDate;  // LocalDate is immutable
    private final List<Transaction> transactions;  // Custom mutable objects
    
    public ImmutableBankAccount(String accountNumber, String accountHolder,
                               double balance, LocalDate openDate,
                               List<Transaction> transactions) {
        // Validate inputs
        Objects.requireNonNull(accountNumber, "Account number cannot be null");
        Objects.requireNonNull(accountHolder, "Account holder cannot be null");
        Objects.requireNonNull(openDate, "Open date cannot be null");
        
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.openDate = openDate;  // LocalDate is immutable, no copy needed
        
        // Deep copy for mutable objects
        List<Transaction> copy = new ArrayList<>();
        for (Transaction t : transactions) {
            copy.add(new Transaction(t));  // Use copy constructor
        }
        this.transactions = Collections.unmodifiableList(copy);
    }
    
    // Getters
    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolder() { return accountHolder; }
    public double getBalance() { return balance; }
    public LocalDate getOpenDate() { return openDate; }
    
    public List<Transaction> getTransactions() {
        // Return deep copy
        List<Transaction> copy = new ArrayList<>();
        for (Transaction t : transactions) {
            copy.add(new Transaction(t));
        }
        return Collections.unmodifiableList(copy);
    }
    
    // Instead of setters, create new instances
    public ImmutableBankAccount withDeposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        List<Transaction> newTransactions = new ArrayList<>(transactions);
        newTransactions.add(new Transaction(LocalDate.now(), "DEPOSIT", amount));
        
        return new ImmutableBankAccount(
            accountNumber, accountHolder, balance + amount, 
            openDate, newTransactions
        );
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImmutableBankAccount)) return false;
        ImmutableBankAccount that = (ImmutableBankAccount) o;
        return Double.compare(that.balance, balance) == 0 &&
               accountNumber.equals(that.accountNumber) &&
               accountHolder.equals(that.accountHolder);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, accountHolder, balance);
    }
}

// Supporting mutable class
class Transaction {
    private LocalDate date;
    private String type;
    private double amount;
    
    public Transaction(LocalDate date, String type, double amount) {
        this.date = date;
        this.type = type;
        this.amount = amount;
    }
    
    // Copy constructor
    public Transaction(Transaction other) {
        this.date = other.date;
        this.type = other.type;
        this.amount = other.amount;
    }
    
    // Getters and setters
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}