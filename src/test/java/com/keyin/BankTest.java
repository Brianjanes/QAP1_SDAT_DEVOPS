package com.keyin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    private Bank bank;
    private Account testAccount;
    private String accountNumber;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        testAccount = bank.createAccount("Test Holder");
        accountNumber = testAccount.getAccountNumber();
    }

    @Test
    void depositShouldIncreaseBalance() {
        // Given
        double initialBalance = bank.getBalance(accountNumber);
        double depositAmount = 100.0;

        // When
        bank.deposit(accountNumber, depositAmount);

        // Then
        assertEquals(initialBalance + depositAmount, bank.getBalance(accountNumber),
                "Balance should increase by deposit amount");
    }

    @Test
    void withdrawShouldDecreaseBalance() {
        // Given
        bank.deposit(accountNumber, 100.0); // Setup initial balance
        double initialBalance = bank.getBalance(accountNumber);
        double withdrawAmount = 50.0;

        // When
        bank.withdraw(accountNumber, withdrawAmount);

        // Then
        assertEquals(initialBalance - withdrawAmount, bank.getBalance(accountNumber),
                "Balance should decrease by withdrawal amount");
    }

    @Test
    void withdrawShouldFailWithInsufficientFunds() {
        // Given
        bank.deposit(accountNumber, 50.0); // Setup initial balance
        double withdrawAmount = 100.0;

        // When & Then
        assertThrows(IllegalStateException.class, () -> {
            bank.withdraw(accountNumber, withdrawAmount);
        }, "Should throw exception when withdrawing more than balance");
    }
}