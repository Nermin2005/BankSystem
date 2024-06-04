import business.concretes.*;
import entities.BankAccaunt;
import entities.Customer;
import enums.AccauntTypes;
import enums.PersonType;
import exceptions.InsufficientFundsException;
import exceptions.InvalidAccountException;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BankAccauntManager bankAccauntManager = new BankAccauntManager();
        BankCustomerManager bankCustomerManager=new BankCustomerManager();

        Customer customer1 = new Customer("Nermin Memmedli", "10 mkr", "21137289", "dekdn@jssw.com", PersonType.CUSTOMER);
        Customer customer2 = new Customer("Salamm", "11 mkr", "582382", "hduais@asjsd.com", PersonType.CUSTOMER);
        bankCustomerManager.addCustomer(customer1);
        bankCustomerManager.addCustomer(customer2);

        BankAccaunt savingsAccount1 = new BankAccaunt(AccauntTypes.Savingsaccounts);
        BankAccaunt checkingAccount1 = new BankAccaunt(AccauntTypes.Checkingaccounts);
        BankAccaunt savingsAccount2 = new BankAccaunt(AccauntTypes.Savingsaccounts);
        bankAccauntManager.addAccount(savingsAccount1);
        bankAccauntManager.addAccount(checkingAccount1);
        bankAccauntManager.addAccount(savingsAccount2);

        BankProcessManager bankProcessManager=new BankProcessManager();
        bankProcessManager.depozitMoney(savingsAccount1, 1050.0);
        bankProcessManager.depozitMoney(checkingAccount1, 500.0);
        bankProcessManager.depozitMoney(savingsAccount2, 1500.0);

        try {
            bankProcessManager.withdrawMoney(savingsAccount1, 200.0);
            bankProcessManager.transferMoney(savingsAccount2, checkingAccount1, 300.0);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        CalculateInterest calculateInterest=new CalculateInterest();
        calculateInterest.applyMonthlyInterest(savingsAccount1);
        calculateInterest.applyMonthlyInterest(savingsAccount2);

        bankAccauntManager.displayAccountDetails(savingsAccount1.getAccountNumber());
        bankAccauntManager.displayAccountDetails(checkingAccount1.getAccountNumber());
        bankAccauntManager.displayAccountDetails(savingsAccount2.getAccountNumber());

        bankCustomerManager.displayCustomerDetails(customer1.getCustomerID());
        bankCustomerManager.displayCustomerDetails(customer2.getCustomerID());

        LocalDate currentMonth = LocalDate.now();
        MonthlyProcess.generateStatement(savingsAccount1, currentMonth);
        MonthlyProcess.generateStatement(checkingAccount1, currentMonth);
        MonthlyProcess.generateStatement(savingsAccount2, currentMonth);

        TransactionHistoryExport.export(savingsAccount1, "savingsAccount1.txt");
        TransactionHistoryExport.export(checkingAccount1, "checkingAccount1.txt");
        TransactionHistoryExport.export(savingsAccount2, "savingsAccount2.txt");
    }
}
