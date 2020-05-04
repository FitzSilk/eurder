package be.adrienhelin.project.service.items;

import be.adrienhelin.project.domain.items.Stock;

public class ItemDto {

    private Integer id;
    private String name;
    private String description;
    private double price;
    private int amount;
    private String visualLink;
    private Stock stock;

    public ItemDto() {
    }

    public ItemDto(Integer id) {
        this.id = id;
    }

    public ItemDto(String name, String description, double price, int amount, String visualLink) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.visualLink = visualLink;
        setStock();
    }

    public ItemDto(Integer id, String name, String description, double price, int amount, String visualLink) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.visualLink = visualLink;
        setStock();
    }

    public void setStock() {
        if (this.amount > 9) this.stock = Stock.HIGH;
        else if (this.amount > 4) this.stock = Stock.MEDIUM;
        else this.stock = Stock.LOW;
    }

    public Integer getId() {
        return id;
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

    public String getVisualLink() {
        return visualLink;
    }

    public Stock getStock() {
        setStock();
        return stock;
    }
}
