package be.adrienhelin.project.domain.items;

import io.swagger.models.auth.In;

import javax.persistence.*;
import java.time.LocalDate;

@Table
@Entity
public class ItemGroup {

    @Id
    @Column(name = "item_group_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemGroupId;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "item_amount")
    private int amount;

    @Column(name = "shipping_date")
    private LocalDate shippingDate;

    public ItemGroup() {
    }

    public ItemGroup(ItemGroupBuilder itemGroupBuilder) {
        this.itemGroupId = itemGroupBuilder.getItemGroupId();
        this.item = itemGroupBuilder.getItem();
        this.amount = itemGroupBuilder.getAmount();
        this.shippingDate = (LocalDate.now()).plusDays(1);
    }

    public Integer getItemGroupId() {
        return itemGroupId;
    }

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public static class ItemGroupBuilder {

        private Integer itemGroupId;
        private Item item;
        private Integer amount;
        private LocalDate shippingDate;

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

        public ItemGroupBuilder withShippingDate(LocalDate shippingDate) {
            this.shippingDate = shippingDate;
            return this;
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

        public LocalDate getShippingDate() {
            return shippingDate;
        }
    }
}
