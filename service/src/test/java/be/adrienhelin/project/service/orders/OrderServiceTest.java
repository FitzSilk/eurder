package be.adrienhelin.project.service.orders;

import org.junit.jupiter.api.Test;

class OrderServiceTest {

    @Test
    void givenAnItem_andACustomer_shouldBeAble_toOrder() {
        /*//GIVEN
        CustomerRepository customerRepository = new CustomerRepository();
        ItemRepository itemRepository = new ItemRepository();
        OrderMapper orderMapper = new OrderMapper();
        OrderRepository orderRepository = new OrderRepository();
        OrderService orderService = new OrderService(orderMapper, orderRepository, customerRepository, itemRepository);
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
        Assertions.assertFalse(orderRepository.getAllOrders().isEmpty());*/
    }

}