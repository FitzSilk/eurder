package be.adrienhelin.project.domain.items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;

import java.time.LocalDate;

public class ItemGroup {

    private final double amount;
    private final LocalDate shippingDate;
    @JsonDeserialize(using = StringDeserializer.class)
    @JsonSerialize(using = StringSerializer.class)
    public final String itemId;

    @JsonCreator
    public ItemGroup(@JsonProperty("itemId") String itemId,
                     @JsonProperty("amount") double amount) {
        this.itemId = itemId;
        this.amount = amount;
        /*if((itemRepository.getItemById(itemId)).getAmount() != 0) */
        this.shippingDate = (LocalDate.now()).plusDays(1);
        /*else this.shippingDate = (LocalDate.now()).plusDays(7);*/
    }

    public String getItemId() {
        return itemId;
    }

}
