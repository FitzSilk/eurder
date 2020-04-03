package be.adrienhelin.project.service.orders;

import be.adrienhelin.project.domain.customers.Customer;
import be.adrienhelin.project.domain.items.Item;
import be.adrienhelin.project.domain.items.ItemGroup;
import be.adrienhelin.project.domain.items.ItemRepository;
import be.adrienhelin.project.domain.orders.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static be.adrienhelin.project.domain.customers.CustomerBuilder.customerBuilder;
import static be.adrienhelin.project.domain.items.ItemBuilder.itemBuilder;

class OrderServiceTest {

    @Test
    void givenAnItem_andACustomer_shouldBeAble_toOrder() {
        //GIVEN
        OrderMapper orderMapper = new OrderMapper();
        OrderRepository orderRepository = new OrderRepository();
        OrderService orderService = new OrderService(orderMapper, orderRepository);
        Item item = itemBuilder()
                .withName("Butter")
                .withDescription("Well, it's useful.")
                .withPrice(2.95)
                .withAmount(5)
                .build();
        Customer customer = customerBuilder()
                .withFirstName("John")
                .withLastName("Doe")
                .withEmail("john.doe@dead.com")
                .withPassword("DEAD")
                .build();
        List<ItemGroup> order = new ArrayList<>();
        ItemGroup itemGroup = new ItemGroup(item.getId(), item.getAmount());
        order.add(itemGroup);
        //WHEN
        CreateOrderDto createOrderDto = new CreateOrderDto(customer.getId(), order);
        orderService.addAnOrder(createOrderDto);
        //THEN
        Assertions.assertFalse(orderRepository.getAllOrders().isEmpty());
    }

}