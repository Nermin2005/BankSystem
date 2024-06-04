package entities;

import enums.AccauntTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class BankAccaunt {
    private String accountNumber;
    private double balance;
    private AccauntTypes accountType;
    private List<Transaction> transactionHistory;
Random random=new Random();
    public BankAccaunt(AccauntTypes accountType) {
        this.accountNumber = String.format("%04d", random.nextInt(10000)); ;
        this.accountType = accountType;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccauntTypes getAccountType() {
        return accountType;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    @Override
    public String toString() {
        return "AccountNumber: " + accountNumber + ", Balance: " + balance + ", AccountType: " + accountType;
    }

}
