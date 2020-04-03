package be.adrienhelin.project.domain.orders;

import be.adrienhelin.project.domain.customers.Customer;
import be.adrienhelin.project.domain.items.ItemGroup;

import java.util.List;

public class OrderBuilder {

    private String customerId;
    private List<ItemGroup> orderList;

    protected OrderBuilder() {
    }

    public static OrderBuilder orderBuilder() {
        return new OrderBuilder();
    }

    public Order build() {
        return new Order(this);
    }

    public OrderBuilder withCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public OrderBuilder withOrderList(List<ItemGroup> orderList) {
        this.orderList = orderList;
        return this;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<ItemGroup> getOrderList() {
        return orderList;
    }
}
