package business.abstracts;

import entities.Customer;

public interface BankCustomerService {
    void addCustomer(Customer customer);
    void deleteCustomer(String customerID);
    Customer getCustomer(String customerID);
    void displayCustomerDetails(String customerID);
}
