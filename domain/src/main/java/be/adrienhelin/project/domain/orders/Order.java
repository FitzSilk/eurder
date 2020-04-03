package be.adrienhelin.project.domain.orders;

import be.adrienhelin.project.domain.customers.Customer;
import be.adrienhelin.project.domain.items.ItemGroup;

import java.util.List;
import java.util.UUID;

public class Order {

    private final String customerId;
    private final String id;
    private final List<ItemGroup> orderList;

    public Order(OrderBuilder orderBuilder) {
        this.id = UUID.randomUUID().toString();
        this.customerId = orderBuilder.getCustomerId();
        this.orderList = orderBuilder.getOrderList();
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getId() {
        return id;
    }

    public List<ItemGroup> getOrderList() {
        return orderList;
    }
}
