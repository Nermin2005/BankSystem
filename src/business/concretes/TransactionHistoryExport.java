package business.concretes;

import entities.BankAccaunt;
import entities.Transaction;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TransactionHistoryExport {
    public static void export(BankAccaunt account, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Date,Type,Amount,Status\n");
            for (Transaction transaction : account.getTransactionHistory()) {
                writer.write(transaction.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
