package be.adrienhelin.project.service.orders;

import be.adrienhelin.project.domain.items.ItemGroup;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CreateOrderDto {

    private final Integer customerId;
    private final List<ItemGroup> orderList;

    @JsonCreator
    public CreateOrderDto(@JsonProperty("customerId") Integer customerId,
                          @JsonProperty("orderList") List<ItemGroup> orderList) {
        this.customerId = customerId;
        this.orderList = orderList;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public List<ItemGroup> getOrderList() {
        return orderList;
    }
}
