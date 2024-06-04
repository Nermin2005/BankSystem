package business.abstracts;

import entities.BankAccaunt;
import enums.AccauntTypes;
import entities.Customer;
import exceptions.InvalidAccountException;

public interface BankAccauntService {
    void addAccount(BankAccaunt account);
    void deleteAccount(String accountNumber) throws InvalidAccountException;
    void getAccount(String accountNumber) throws InvalidAccountException;
    void displayAccountDetails(String accountNumber);

}
