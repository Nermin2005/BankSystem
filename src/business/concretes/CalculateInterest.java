package business.concretes;

import entities.BankAccaunt;
import entities.Transaction;
import enums.AccauntTypes;
import enums.TransactionStatus;
import enums.TransactionType;

public class CalculateInterest {
    private static final double INTEREST_RATE = 0.05;

    public static void applyMonthlyInterest(BankAccaunt account) {
        if (account.getAccountType() == AccauntTypes.Savingsaccounts) {
            double interest = account.getBalance() * INTEREST_RATE / 12;
            account.setBalance(account.getBalance() + interest);
            account.getTransactionHistory().add(new Transaction(TransactionType.DEPOSIT, interest, TransactionStatus.SUCCESS));
        }
    }
}
