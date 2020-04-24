package be.adrienhelin.project.domain.customers;

import org.junit.jupiter.api.Test;

import static be.adrienhelin.project.domain.customers.Address.AddressBuilder.addressBuilder;
import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void givenAnAddress_shouldReturn_trueValues() {
        //GIVEN
        Address newAddress = addressBuilder()
                .withStreet("Helihavenlaan")
                .withStreetNumber("22")
                .withPostalCode("1000")
                .withCity("Brussels")
                .build();
        //WHEN
        String actualResult = newAddress.toString();
        String expectedResult = "Helihavenlaan, 22 - 1000 Brussels";
        //THEN
        assertEquals(expectedResult, actualResult);
    }

}