package be.adrienhelin.project.service.orders;

import be.adrienhelin.project.domain.items.ItemGroup;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CreateOrderDto {

    private final String customerId;
    private final List<ItemGroup> orderList;

    @JsonCreator
    public CreateOrderDto(@JsonProperty("customerId") String customerId,
                          @JsonProperty("orderList") List<ItemGroup> orderList) {
        this.customerId = customerId;
        this.orderList = orderList;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<ItemGroup> getOrderList() {
        return orderList;
    }
}
