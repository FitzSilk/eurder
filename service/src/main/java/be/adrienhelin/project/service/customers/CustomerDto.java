package be.adrienhelin.project.service.customers;

import be.adrienhelin.project.domain.customers.Address;
import be.adrienhelin.project.domain.orders.Order;

import java.util.List;

public class CustomerDto {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Address address;
    private List<Order> orderList;

    public CustomerDto(String firstName, String lastName, String email, String phoneNumber, Address address, List<Order> orderList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orderList = orderList;
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
