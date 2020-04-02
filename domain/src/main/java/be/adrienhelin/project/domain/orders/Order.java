package be.adrienhelin.project.domain.orders;

import be.adrienhelin.project.domain.customers.Customer;
import be.adrienhelin.project.domain.items.ItemGroup;

import java.util.List;
import java.util.UUID;

public class Order {

    private final Customer customer;
    private final String id;
    private final List<ItemGroup> orderList;

    public Order(OrderBuilder orderBuilder) {
        this.id = UUID.randomUUID().toString();
        this.customer = orderBuilder.getCustomer();
        this.orderList = orderBuilder.getOrderList();
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getId() {
        return id;
    }

    public List<ItemGroup> getOrderList() {
        return orderList;
    }
}
