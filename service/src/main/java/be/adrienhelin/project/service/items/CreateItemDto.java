package be.adrienhelin.project.service.items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateItemDto {

    private String name;
    private String description;
    private double price;
    private int amount;

    @JsonCreator
    public CreateItemDto(@JsonProperty("name") String name,
                         @JsonProperty("description") String description,
                         @JsonProperty("price") double price,
                         @JsonProperty("amount") int amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}
