package be.adrienhelin.project.service.customers;

import be.adrienhelin.project.domain.customers.Address;
import be.adrienhelin.project.domain.customers.Customer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

public class CustomerDto {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private Address address;

    @JsonCreator
    public CustomerDto(@JsonProperty("firstName") String firstName,
                       @JsonProperty("lastName")String lastName,
                       @JsonProperty("email")String email,
                       @JsonProperty("password")String password,
                       @JsonProperty("phoneNumber")String phoneNumber,
                       @JsonProperty("address")Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public CustomerDto(Integer id, String firstName, String lastName, String email, String password, String phoneNumber, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Integer getId() {
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
