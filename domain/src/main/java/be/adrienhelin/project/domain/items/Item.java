package be.adrienhelin.project.domain.items;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "item")
public class Item implements Comparable<Item> {

    @Id
    @Column(name = "item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "item_name")
    private String name;

    @Column(name = "item_description")
    private String description;

    @Column(name = "item_price")
    private double price;

    @Column(name = "item_amount")
    private int amount;

    @Column(name = "item_link")
    private String visualLink;

    @Transient
    private Stock stock;

    public Item() {
    }

    public Item(ItemBuilder itemBuilder) {
        this.id = itemBuilder.getId();
        this.name = itemBuilder.getName();
        this.description = itemBuilder.getDescription();
        this.price = itemBuilder.getPrice();
        this.amount = itemBuilder.getAmount();
        this.visualLink = itemBuilder.getVisualLink();
        setStock();
    }

    private void setStock() {
        if (this.amount > 9) this.stock = Stock.HIGH;
        else if (this.amount > 4) this.stock = Stock.MEDIUM;
        else this.stock = Stock.LOW;
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

    public Integer getId() {
        return id;
    }

    public String getVisualLink() {
        return visualLink;
    }

    public Stock getStock() {
        setStock();
        return stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Item o) {
        return this.getAmount() - o.getAmount();
    }

    public static class ItemBuilder {

        private Integer id;
        private String name;
        private String description;
        private double price;
        private int amount;
        private String visualLink;
        private Stock stock;

        protected ItemBuilder() {
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

        public ItemBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public ItemBuilder withVisualLink(String link) {
            this.visualLink = link;
            return this;
        }

        public ItemBuilder withStock(Stock stock) {
            this.stock = stock;
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

        public Integer getId() {
            return id;
        }

        public String getVisualLink() {
            return visualLink;
        }

        public Stock getStock() {
            return stock;
        }
    }

}

