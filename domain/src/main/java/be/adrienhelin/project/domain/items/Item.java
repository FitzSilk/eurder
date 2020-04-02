package be.adrienhelin.project.domain.items;

import java.util.UUID;

public class Item {

    private final String id;
    private final String name;
    private final String description;
    private final double price;
    private int amount;

    public Item(ItemBuilder itemBuilder) {
        id = UUID.randomUUID().toString();
        this.name = itemBuilder.getName();
        this.description = itemBuilder.getDescription();
        this.price = itemBuilder.getPrice();
        this.amount = itemBuilder.getAmount();
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

    public String getId() {
        return id;
    }
}
