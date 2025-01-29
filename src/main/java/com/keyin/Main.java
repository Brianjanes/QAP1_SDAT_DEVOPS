package com.keyin;

public class Main {
    public static void main(String[] args) {
        // Create a new bank
        Bank bank = new Bank();

        // Create some test accounts
        Account account1 = bank.createAccount("John Doe");
        Account account2 = bank.createAccount("Jane Smith");

        System.out.println("Created accounts:");
        System.out.println("Account 1: " + account1.getAccountHolder() + " - " + account1.getAccountNumber());
        System.out.println("Account 2: " + account2.getAccountHolder() + " - " + account2.getAccountNumber());

        try {
            // Demonstrate deposits
            System.out.println("\nMaking deposits...");
            bank.deposit(account1.getAccountNumber(), 1000.0);
            bank.deposit(account2.getAccountNumber(), 500.0);

            // Show balances
            System.out.println("Account 1 balance: $" + bank.getBalance(account1.getAccountNumber()));
            System.out.println("Account 2 balance: $" + bank.getBalance(account2.getAccountNumber()));

            // Demonstrate successful withdrawal
            System.out.println("\nWithdrawing $300 from Account 1...");
            bank.withdraw(account1.getAccountNumber(), 300.0);
            System.out.println("Account 1 balance: $" + bank.getBalance(account1.getAccountNumber()));

            // Demonstrate failed withdrawal (insufficient funds)
            System.out.println("\nAttempting to withdraw $1000 from Account 2 (should fail)...");
            bank.withdraw(account2.getAccountNumber(), 1000.0);

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}