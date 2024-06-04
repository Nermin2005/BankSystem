package business.concretes;

import business.abstracts.BankCustomerService;
import entities.Customer;

import java.util.HashMap;
import java.util.Map;

public class BankCustomerManager implements BankCustomerService {
    private Map<String, Customer> customers;

    public BankCustomerManager() {
customers=new HashMap<>();
    }
    public void addCustomer(Customer customer) {
        customers.put(customer.getCustomerID(), customer);
    }

    public void deleteCustomer(String customerID) {
        customers.remove(customerID);
    }

    public Customer getCustomer(String customerID) {
        return customers.get(customerID);
    }
    public void displayCustomerDetails(String customerID) {
        Customer customer = customers.get(customerID);
        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("Customer not found");
        }
    }
}
