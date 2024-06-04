package business.concretes;

import business.abstracts.BankAccauntService;
import entities.BankAccaunt;
import entities.Customer;
import exceptions.InvalidAccountException;

import java.util.HashMap;
import java.util.Map;

public class BankAccauntManager implements BankAccauntService {
    private Map<String, BankAccaunt> accounts;

    public BankAccauntManager() {
        accounts = new HashMap<>();
    }

    public void addAccount(BankAccaunt account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public void deleteAccount(String accountNumber) throws InvalidAccountException {
        if (accounts.containsKey(accountNumber)) {
            accounts.remove(accountNumber);
        } else {
            throw new InvalidAccountException("Account number " + accountNumber + " does not exist.");
        }
    }

    public void getAccount(String accountNumber) throws InvalidAccountException {
        BankAccaunt account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println(account);
        } else {
            throw new InvalidAccountException("Account number " + accountNumber + " does not exist.");
        }
    }


    public void displayAccountDetails(String accountNumber) {
        BankAccaunt account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println(account);
        } else {
            System.out.println("Account not found");
        }
    }

}
