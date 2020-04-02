package be.adrienhelin.project.domain.items;

public class ItemBuilder {

    private String name;
    private String description;
    private double price;
    private int amount;

    protected ItemBuilder(){
    }

    public static ItemBuilder itemBuilder() {
        return new ItemBuilder();
    }

    public Item build() {
        return new Item(this);
    }

    public ItemBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ItemBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public ItemBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public ItemBuilder withAmount(int amount) {
        this.amount = amount;
        return this;
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
