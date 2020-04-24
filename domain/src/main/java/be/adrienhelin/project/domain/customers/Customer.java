package be.adrienhelin.project.domain.customers;

import javax.persistence.*;

@Table
@Entity
public class Customer {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Embedded
    private Address address;

    public Customer() {
    }

    public Customer(CustomerBuilder customerBuilder) {
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

    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void createOrder() {
        //
    }

    public static class CustomerBuilder {

        private Integer id;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
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

        public CustomerBuilder withID(Integer id) {
            this.id = id;
            return this;
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

        public CustomerBuilder withPassword(String password) {
            this.password = password;
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
}
