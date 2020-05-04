package be.adrienhelin.project.service.orders;

import be.adrienhelin.project.domain.items.ItemGroup;

import java.util.List;

public class OrderDto {

    private Integer orderId;
    private Integer customerId;
    private List<ItemGroup> itemGroup;

    public OrderDto() {

    }

    public OrderDto(Integer orderId, Integer customerId, List<ItemGroup> itemGroup) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.itemGroup = itemGroup;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public List<ItemGroup> getItemGroup() {
        return itemGroup;
    }
}
