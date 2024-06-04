package business.abstracts;

import entities.BankAccaunt;
import exceptions.InsufficientFundsException;

public interface BankProcessService {
    void depozitMoney(BankAccaunt account, double amount);
    void withdrawMoney(BankAccaunt account, double amount) throws InsufficientFundsException;
    void transferMoney(BankAccaunt fromAccount, BankAccaunt toAccount, double amount) throws InsufficientFundsException;


}
