package be.adrienhelin.project.service.orders;

import be.adrienhelin.project.domain.items.ItemGroup;

import java.util.List;

public class OrderDto {

    private final Integer customerId;
    private final Integer id;

    public OrderDto(Integer id, Integer customerId) {
        this.id = id;
        this.customerId = customerId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCustomerId() {
        return customerId;
    }
}
