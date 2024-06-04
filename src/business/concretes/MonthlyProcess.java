package business.concretes;

import entities.BankAccaunt;
import entities.Transaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class MonthlyProcess {

    public static void generateStatement(BankAccaunt account, LocalDate month) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        String monthly = month.format(formatter);

        List<Transaction> transactions = account.getTransactionHistory().stream()
                .filter(transaction -> transaction.getDate().format(formatter).equals(monthly))
                .collect(Collectors.toList());

        System.out.println("Statement for " + account.getAccountNumber() + " for month " + monthly);
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
