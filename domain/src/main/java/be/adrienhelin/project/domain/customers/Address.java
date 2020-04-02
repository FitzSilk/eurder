package be.adrienhelin.project.domain.customers;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Address {

    private final String street;
    private final String streetNumber;
    private final String postalCode;
    private final String city;

    @JsonCreator
    public Address(AddressBuilder addressBuilder) {
        street = addressBuilder.getStreet();
        streetNumber = addressBuilder.getStreetNumber();
        postalCode = addressBuilder.getPostalCode();
        city = addressBuilder.getCity();
    }

    @Override
    public String toString() {
        return street + ", " + streetNumber + " - " + postalCode + " " + city;
    }
}
