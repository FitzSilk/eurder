package be.adrienhelin.project.domain.items;

import be.adrienhelin.project.domain.orders.Order;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "item_group")
public class ItemGroup {

    @Id
    @Column(name = "item_group_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemGroupId;

    @ManyToOne
    @JoinColumn(name = "eurder_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "item_amount")
    private int amount;

    @Column(name = "shipping_date")
    private String shippingDate;

    public ItemGroup() {
    }

    @JsonCreator
    public ItemGroup(ItemGroupBuilder itemGroupBuilder) {
        this.itemGroupId = itemGroupBuilder.getItemGroupId();
        this.order = itemGroupBuilder.getOrder();
        this.item = itemGroupBuilder.getItem();
        this.amount = itemGroupBuilder.getAmount();
        this.shippingDate = itemGroupBuilder.getShippingDate();
    }

    public Integer getItemGroupId() {
        return itemGroupId;
    }

    public Item getItem() {
        return item;
    }

    @JsonIgnore
    public Order getOrder() {
        return order;
    }

    public int getAmount() {
        return amount;
    }

    public String getShippingDate() {
        return shippingDate;
    }

    public static class ItemGroupBuilder {

        private Integer itemGroupId;
        private Item item;
        private Integer amount;
        private String shippingDate;
        private Order order;

        protected ItemGroupBuilder() {
        }

        public static ItemGroupBuilder itemGroupBuilder() {
            return new ItemGroupBuilder();
        }

        public ItemGroup build() {
            return new ItemGroup(this);
        }

        public ItemGroupBuilder withItemGroupId(Integer itemGroupId) {
            this.itemGroupId = itemGroupId;
            return this;
        }

        public ItemGroupBuilder withItemId(Item item) {
            this.item = item;
            return this;
        }

        public ItemGroupBuilder withAmount(Integer amount) {
            this.amount = amount;
            return this;
        }

        public ItemGroupBuilder withShippingDate(String shippingDate) {
            this.shippingDate = shippingDate;
            return this;
        }

        public ItemGroupBuilder withOrder(Order order) {
            this.order = order;
            return this;
        }

        public Order getOrder() {
            return order;
        }

        public Integer getItemGroupId() {
            return itemGroupId;
        }

        public Item getItem() {
            return item;
        }

        public Integer getAmount() {
            return amount;
        }

        public String getShippingDate() {
            return shippingDate;
        }
    }
}
