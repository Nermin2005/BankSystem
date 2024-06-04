package entities;

import enums.PersonType;

import java.util.Random;
import java.util.UUID;

public class Customer {
    private String customerID;
    private String name;
    private String address;
    private String phone;
    private String email;
    private PersonType customerType;
    Random random=new Random();

    public Customer(String name, String address, String phone, String email, PersonType customerType) {
        this.customerID = String.format("%04d", random.nextInt(10000));
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.customerType = customerType;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PersonType getCustomerType() {
        return customerType;
    }

    @Override
    public String toString() {
        return "CustomerID: " + customerID + ", Name: " + name + ", Address: " + address +
                ", Phone: " + phone + ", Email: " + email + ", CustomerType: " + customerType;
    }
}
