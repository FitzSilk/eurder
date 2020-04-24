package be.adrienhelin.project.domain.items;

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

    public ItemGroup(Integer itemGroupId, Item item, int amount) {
        this.itemGroupId = itemGroupId;
        this.item = item;
        this.amount = amount;
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
}
