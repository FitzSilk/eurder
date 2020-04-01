package be.adrienhelin.project.domain.customers;

import be.adrienhelin.project.domain.orders.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Customer {

    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    private final Address address;
    private final List<Order> orderList;

    public Customer(CustomerBuilder customerBuilder) {
        id = UUID.randomUUID().toString();
        orderList = new ArrayList<>();
        this.firstName = customerBuilder.getFirstName();
        this.lastName = customerBuilder.getLastName();
        this.email = customerBuilder.getEmail();
        this.phoneNumber = customerBuilder.getPhoneNumber();
        this.address = customerBuilder.getAddress();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public List<Order> getOrderList() {
        return orderList;
    }
}
