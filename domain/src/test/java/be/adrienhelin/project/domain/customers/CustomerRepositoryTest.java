package be.adrienhelin.project.domain.customers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static be.adrienhelin.project.domain.customers.AddressBuilder.addressBuilder;
import static be.adrienhelin.project.domain.customers.CustomerBuilder.customerBuilder;

class CustomerRepositoryTest {

    @Test
    void givenANewCustomer_shouldReturnIt_inRepository() {
        //GIVEN
        CustomerRepository customerRepository = new CustomerRepository();
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
        customerRepository.register(newCustomer);
        //THEN
        Assertions.assertTrue(customerRepository.getAllCustomers().contains(newCustomer));
    }

}