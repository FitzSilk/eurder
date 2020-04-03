package be.adrienhelin.project.service.customers;

import be.adrienhelin.project.domain.customers.Address;
import com.fasterxml.jackson.annotation.JsonCreator;

public class CustomerDto {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private Address address;

    @JsonCreator
    public CustomerDto(String id, String firstName, String lastName, String email, String password, String phoneNumber, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getId() {
        return id;
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

    public String getPassword() {
        return password;
    }
}
