package be.adrienhelin.project.service.items;

public class ItemDto {

    private Integer id;
    private String name;
    private String description;
    private double price;
    private int amount;
    private String visualLink;

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
    }

    public ItemDto(Integer id, String name, String description, double price, int amount, String visualLink) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.visualLink = visualLink;
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
}
