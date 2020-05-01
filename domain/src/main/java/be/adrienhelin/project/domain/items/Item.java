package be.adrienhelin.project.domain.items;

import javax.persistence.*;
import java.util.Objects;

@Table
@Entity
public class Item {

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
    private String coverLink;

    public Item() {
    }

    public Item(ItemBuilder itemBuilder) {
        this.id = itemBuilder.getId();
        this.name = itemBuilder.getName();
        this.description = itemBuilder.getDescription();
        this.price = itemBuilder.getPrice();
        this.amount = itemBuilder.getAmount();
        this.coverLink = itemBuilder.getCoverLink();
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

    public String getCoverLink() {
        return coverLink;
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

    public static class ItemBuilder {

        private Integer id;
        private String name;
        private String description;
        private double price;
        private int amount;
        private String coverLink;

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

        public ItemBuilder withCoverLink(String link) {
            this.coverLink = link;
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

        public String getCoverLink() {
            return coverLink;
        }
    }

}
