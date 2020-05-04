package be.adrienhelin.project.service.orders;

import be.adrienhelin.project.domain.orders.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderMapper orderMapper, OrderRepository orderRepository) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
    }

    public OrderDto addAnOrder(OrderDto orderDto) {
        return orderMapper.toDto(orderRepository.save(orderMapper.toOrder(orderDto)));
    }

    public Collection<OrderDto> getAllOrders(Integer id) {
        return orderMapper.toDto(orderRepository.findAllById(id));
    }
}
