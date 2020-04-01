package be.adrienhelin.project.domain.customers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void givenAVisitor_shouldBeAble_toRegister() {
        //GIVEN
        Customer newCustomer = CustomerBuilder.customerBuilder()
                .withFirstName("John")
                .withLastName("Doe")
                .withEmail("john.doe@dead.com")
                .build();
        //WHEN
        String expectedFirstName = "John";
        String expectedLastName = "Doe";
        String expectedEmail = "john.doe@dead.com";
        //THEN
        assertEquals(expectedFirstName, newCustomer.getFirstName());
        assertEquals(expectedLastName, newCustomer.getLastName());
        assertEquals(expectedEmail, newCustomer.getEmail());
    }

}