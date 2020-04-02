package be.adrienhelin.project.service.orders;

import be.adrienhelin.project.domain.customers.Customer;
import be.adrienhelin.project.domain.items.ItemGroup;

import java.util.List;

public class OrderDto {

    private final Customer customer;
    private final String id;
    private final List<ItemGroup> orderList;

    public OrderDto(String id, Customer customer, List<ItemGroup> orderList) {
        this.id = id;
        this.customer = customer;
        this.orderList = orderList;
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
