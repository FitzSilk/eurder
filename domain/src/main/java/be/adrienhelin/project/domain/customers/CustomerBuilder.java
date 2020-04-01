package be.adrienhelin.project.domain.customers;

public class CustomerBuilder {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Address address;

    protected CustomerBuilder() {
    }

    public static CustomerBuilder customerBuilder() {
        return new CustomerBuilder();
    }

    public Customer build() {
        return new Customer(this);
    }

    public CustomerBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CustomerBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CustomerBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public CustomerBuilder withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public CustomerBuilder withAddress(Address address) {
        this.address = address;
        return this;
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
}
