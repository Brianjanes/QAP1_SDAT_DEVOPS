# Banking Application

A simple Java banking application that supports basic account management operations.

## Features

- Account creation with unique account numbers
- Deposit and withdrawal operations
- Balance inquiries
- Built-in validation for transactions
- JUnit 5 testing suite

## Project Structure

```
src/
├── main/java/com.keyin/
│ ├── Account.java - Handles individual account operations
│ ├── Bank.java - Manages all banking operations
│ └── Main.java - Demo application
└── test/java/com.keyin/
└── BankTest.java - Test suite for banking operations
```

## Dependencies

- JUnit Jupiter 5.9.2 - Testing framework
- Maven Surefire Plugin 3.1.2 - Test execution

## Testing

The project includes three core test scenarios:

1. Deposit validation - Ensures deposits correctly increase account balance
2. Withdrawal validation - Verifies withdrawals properly decrease balance
3. Insufficient funds handling - Confirms proper error handling for invalid withdrawals

## Clean Code Practices

1. Clear method names that describe their purpose (e.g., `createAccount`, `deposit`, `withdraw`)
2. Proper exception handling for invalid operations
3. Separation of concerns between Account and Bank classes

## Running the Project

To run tests:

```bash
  mvn  test
```

## GitHub Actions

This project uses GitHub Actions for continuous integration:

- Automatically runs tests on push to main/dev branches
- Validates all pull requests
- Uses Maven for build and test automation

## Usage Example

```java
Bank bank = new Bank();
Account account = bank.createAccount("John Doe");
bank.deposit(account.getAccountNumber(), 100.0);
double balance = bank.getBalance(account.getAccountNumber()); // Returns 100.0
```
