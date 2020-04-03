package be.adrienhelin.project.domain.items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;

public class ItemGroup {

    private final int amount;
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonSerialize(using = StringSerializer.class)
    private final String itemId;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private final LocalDate shippingDate;

    @JsonCreator
    public ItemGroup(@JsonProperty("itemId") String itemId,
                     @JsonProperty("amount") int amount) {
        this.itemId = itemId;
        this.amount = amount;
        /*if((itemRepository.getItemById(itemId)).getAmount() != 0) */
        this.shippingDate = (LocalDate.now()).plusDays(1);
        /*else this.shippingDate = (LocalDate.now()).plusDays(7);*/
    }

    public String getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}
