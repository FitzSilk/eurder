package be.adrienhelin.project.service.orders;

import be.adrienhelin.project.domain.customers.CustomerRepository;
import be.adrienhelin.project.domain.items.ItemRepository;
import be.adrienhelin.project.domain.orders.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public OrderService(OrderMapper orderMapper, OrderRepository orderRepository, CustomerRepository customerRepository, ItemRepository itemRepository) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.itemRepository = itemRepository;
    }

    public OrderDto addAnOrder(OrderDto orderDto) {
        return orderMapper.toDto(orderRepository.save(orderMapper.toOrder(orderDto)));
    }

    public Collection<OrderDto> getAllOrders() {
        return orderMapper.toDto(orderRepository.findAll());
    }
}
