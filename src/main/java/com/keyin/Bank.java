package com.keyin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bank {
    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public Account createAccount(String holder) {
        // Generates a random account number with UUID
        String accountNumber = UUID.randomUUID().toString().substring(0, 8);
        Account newAccount = new Account(accountNumber, holder);
        accounts.add(newAccount);
        return newAccount;
    }

    public void deposit(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        account.deposit(amount);
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        account.withdraw(amount);
    }

    public double getBalance(String accountNumber) {
        Account account = findAccount(accountNumber);
        return account.getBalance();
    }

    private Account findAccount(String accountNumber) {
        return accounts.stream()
                .filter(a -> a.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
    }
}