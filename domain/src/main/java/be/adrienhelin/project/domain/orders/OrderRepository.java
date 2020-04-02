package be.adrienhelin.project.domain.orders;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class OrderRepository {

    private final ConcurrentHashMap<String, Order> orderRepository;

    public OrderRepository() {
        this.orderRepository = new ConcurrentHashMap<>();
    }

    public Collection<Order> getAllOrders() {
        return orderRepository.values();
    }

    public Order addAnOrder(Order order) {
        orderRepository.put(order.getId(), order);
        return order;
    }
}
