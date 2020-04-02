package be.adrienhelin.project.domain.orders;

import be.adrienhelin.project.domain.customers.Customer;
import be.adrienhelin.project.domain.items.ItemGroup;

import java.util.List;

public class OrderBuilder {

    private Customer customer;
    private List<ItemGroup> orderList;

    protected OrderBuilder() {
    }

    public static OrderBuilder orderBuilder() {
        return new OrderBuilder();
    }

    public Order build() {
        return new Order(this);
    }

    public OrderBuilder withCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public OrderBuilder withOrderList(List<ItemGroup> orderList) {
        this.orderList = orderList;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<ItemGroup> getOrderList() {
        return orderList;
    }
}
