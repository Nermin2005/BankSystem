package business.concretes;

import business.abstracts.BankProcessService;
import entities.BankAccaunt;
import entities.Transaction;
import enums.TransactionStatus;
import enums.TransactionType;
import exceptions.InsufficientFundsException;

public class BankProcessManager implements BankProcessService {
    @Override
    public void depozitMoney(BankAccaunt account, double amount) {
        if (amount > 0) {
            account.setBalance(account.getBalance() + amount);
            Transaction transaction=new Transaction(TransactionType.DEPOSIT, amount, TransactionStatus.SUCCESS);
            account.getTransactionHistory().add(transaction);
        } else {
            Transaction transaction=new Transaction(TransactionType.DEPOSIT, amount, TransactionStatus.FAILED);
            account.getTransactionHistory().add(transaction);
        }
    }

    @Override
    public void withdrawMoney(BankAccaunt account, double amount) throws InsufficientFundsException{
        if (amount > 0 && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            account.getTransactionHistory().add(new Transaction(TransactionType.WITHDRAW, amount, TransactionStatus.SUCCESS));
        } else {
            account.getTransactionHistory().add(new Transaction(TransactionType.WITHDRAW, amount, TransactionStatus.FAILED));
            throw new InsufficientFundsException("Lack of money for withdrawal");
        }
    }

    @Override
    public void transferMoney(BankAccaunt fromAccount, BankAccaunt toAccount, double amount) throws InsufficientFundsException {
        if (fromAccount.getBalance() >= amount) {
            withdrawMoney(fromAccount, amount);
            depozitMoney(toAccount, amount);
        } else {
            throw new InsufficientFundsException("Insufficient money for transfer");
        }
    }
    }


