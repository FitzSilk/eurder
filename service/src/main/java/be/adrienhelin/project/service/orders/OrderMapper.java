package be.adrienhelin.project.service.orders;

import be.adrienhelin.project.domain.orders.Order;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

import static be.adrienhelin.project.domain.orders.OrderBuilder.orderBuilder;

@Component
public class OrderMapper {

    public OrderDto toDto(Order order) {
        return new OrderDto(order.getId(), order.getCustomer(), order.getOrderList());
    }

    public Collection<OrderDto> toDto(Collection<Order> orders) {
        return orders.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Order toOrder(OrderDto orderDto) {
        return orderBuilder()
                .withCustomer(orderDto.getCustomer())
                .withOrderList(orderDto.getOrderList())
                .build();
    }
}
