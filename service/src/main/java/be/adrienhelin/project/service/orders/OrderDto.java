package be.adrienhelin.project.service.orders;

import be.adrienhelin.project.domain.customers.Customer;
import be.adrienhelin.project.domain.items.ItemGroup;

import java.util.List;

public class OrderDto {

    private final String customerId;
    private final String id;
    private final List<ItemGroup> orderList;

    public OrderDto(String id, String customerId, List<ItemGroup> orderList) {
        this.id = id;
        this.customerId = customerId;
        this.orderList = orderList;
    }

    public String getId() {
        return id;
    }

    public List<ItemGroup> getOrderList() {
        return orderList;
    }

    public String getCustomerId() {
        return customerId;
    }
}
