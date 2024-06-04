package entities;

import enums.TransactionStatus;
import enums.TransactionType;

import java.time.LocalDate;

public class Transaction {
    private TransactionType type;
    private double amount;
    private TransactionStatus status;
    private LocalDate date;

    public Transaction(TransactionType type, double amount, TransactionStatus status) {
        this.type = type;
        this.amount = amount;
        this.status = status;
        this.date = LocalDate.now();
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type=" + type +
                ", amount=" + amount +
                ", status=" + status +
                ", date=" + date +
                '}';
    }


}
