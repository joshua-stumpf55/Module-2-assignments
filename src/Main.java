
import java.util.Scanner;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Create an Account object with constructor
        Account acc1 = new Account();

        // Print account details
        System.out.println("Account 1 ID: " + acc1.getId());
        System.out.println("Account 1 Balance: $" + acc1.getBalance());

        // Withdraw $2,500
        acc1.withdraw(2500);
        System.out.println("Balance after withdrawing $2,500: $" + acc1.getBalance());

        // Try to withdraw an amount larger than the balance
        acc1.withdraw(20000);
    }

    public static class Account { // Static nested class

        private int id;
        private double balance;
        private static double annualInterestRate = 0;
        private Date dateCreated;


        public Account() {
            this.id = 1122;
            this.balance = 20000;
            this.dateCreated = new Date();
        }


        public Account(int id, double initialBalance) {
            this.id = id;
            this.balance = initialBalance;
            this.dateCreated = new Date();
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public static double getAnnualInterestRate() {
            return annualInterestRate;
        }

        public static void setAnnualInterestRate(double annualInterestRate) {
            Account.annualInterestRate = annualInterestRate;
        }

        public Date getDateCreated() {
            return dateCreated;
        }

        public double getMonthlyInterestRate() {
            return annualInterestRate / 12 / 100; // Convert annual interest rate to monthly
        }

        public double getMonthlyInterest() {
            return balance * getMonthlyInterestRate();
        }

        // Method to withdraw
        public void withdraw(double amount) {
            if (amount > balance) {
                System.out.println("Insufficient funds. Cannot withdraw $" + amount);
            } else if (amount <= 0) {
                System.out.println("Withdrawal amount must be positive.");
            } else {
                balance -= amount;
                System.out.println("Successfully withdrew $" + amount);
            }
        }

        // Method to deposit
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Successfully deposited $" + amount);
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        }
    }
}
