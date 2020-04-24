package be.adrienhelin.project.service.customers;

import be.adrienhelin.project.domain.customers.Address;
import be.adrienhelin.project.domain.customers.Customer;
import org.junit.jupiter.api.Test;

import static be.adrienhelin.project.domain.customers.Address.AddressBuilder.addressBuilder;
import static be.adrienhelin.project.domain.customers.Customer.CustomerBuilder.customerBuilder;
import static org.junit.jupiter.api.Assertions.*;

class CustomerDtoTest {

    @Test
    void givenInfos_shouldCreate_Dto() {
        //GIVEN
        CustomerMapper customerMapper = new CustomerMapper();
        Address address = addressBuilder()
                .withStreet("Piglane")
                .withStreetNumber("42")
                .withPostalCode("1000")
                .withCity("Brussels")
                .build();
        Customer customer = customerBuilder()
                .withID(13)
                .withFirstName("John")
                .withLastName("Doe")
                .withEmail("john.doe@dead.com")
                .withPassword("DEAD")
                .withPhoneNumber("555-1342-210")
                .withAddress(address)
                .build();
        //THEN
        CustomerDto actualResult = customerMapper.toDto(customer);
        CustomerDto expectedResult = new CustomerDto(13,"John", "Doe", "john.doe@dead.com", "DEAD", "555-1342-210", address);
        //THEN
        assertEquals(expectedResult.getFirstName(), actualResult.getFirstName());
        assertEquals(expectedResult.getLastName(), actualResult.getLastName());
        assertEquals(expectedResult.getEmail(), actualResult.getEmail());
    }

}