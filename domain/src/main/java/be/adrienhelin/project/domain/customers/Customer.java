package be.adrienhelin.project.domain.customers;

import java.util.UUID;

public class Customer {

    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final String phoneNumber;
    private final Address address;

    public Customer(CustomerBuilder customerBuilder) {
        id = UUID.randomUUID().toString();
        this.firstName = customerBuilder.getFirstName();
        this.lastName = customerBuilder.getLastName();
        this.email = customerBuilder.getEmail();
        this.password = customerBuilder.getPassword();
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

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
