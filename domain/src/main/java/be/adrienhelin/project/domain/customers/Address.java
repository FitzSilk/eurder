package be.adrienhelin.project.domain.customers;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(name = "street_name")
    private String street;

    @Column(name = "street_number")
    private String streetNumber;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "city")
    private String city;

    public Address() {
    }

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


    public static class AddressBuilder {

        private String street;
        private String streetNumber;
        private String postalCode;
        private String city;

        protected AddressBuilder() {
        }

        public static AddressBuilder addressBuilder() {
            return new AddressBuilder();
        }

        public Address build() {
            return new Address(this);
        }

        public AddressBuilder withStreet(String street) {
            this.street = street;
            return this;
        }

        public AddressBuilder withStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public AddressBuilder withPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public AddressBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public String getStreet() {
            return street;
        }

        public String getStreetNumber() {
            return streetNumber;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public String getCity() {
            return city;
        }
    }
}
