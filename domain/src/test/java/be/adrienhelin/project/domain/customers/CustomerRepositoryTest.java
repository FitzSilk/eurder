package be.adrienhelin.project.domain.customers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static be.adrienhelin.project.domain.customers.Address.AddressBuilder.addressBuilder;
import static be.adrienhelin.project.domain.customers.Customer.CustomerBuilder.customerBuilder;

class CustomerRepositoryTest {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerRepositoryTest(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Test
    void givenANewCustomer_shouldReturnIt_inRepository() {
        //GIVEN
        Customer newCustomer = customerBuilder()
                .withFirstName("Jeremy")
                .withLastName("Jones")
                .withEmail("jeremy@jones.com")
                .withPhoneNumber("555-1342-210")
                .withAddress(addressBuilder()
                        .withStreet("Piglane")
                        .withStreetNumber("42")
                        .withCity("Brussels")
                        .withPostalCode("1000")
                        .build())
                .build();
        //WHEN
        customerRepository.save(newCustomer);
        //THEN
        Assertions.assertTrue(customerRepository.findAll().contains(newCustomer));
    }

}