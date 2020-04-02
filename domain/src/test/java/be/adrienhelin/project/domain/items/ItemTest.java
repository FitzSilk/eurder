package be.adrienhelin.project.domain.items;

import org.junit.jupiter.api.Test;

import static be.adrienhelin.project.domain.items.ItemBuilder.itemBuilder;
import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void givenAnItem_shouldBeAble_toSeeIt() {
        //GIVEN
        Item newItem = itemBuilder()
                .withName("Dark Side of the Moon")
                .withDescription("Probably the best album of all times")
                .withPrice(13.95)
                .withAmount(5)
                .build();
        //WHEN
        String actualResult = newItem.getName();
        String expectedResult = "Dark Side of the Moon";
        //THEN
        assertEquals(expectedResult, actualResult);
    }

}