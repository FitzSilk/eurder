package be.adrienhelin.project.api.controllers;

import be.adrienhelin.project.service.orders.OrderDto;
import be.adrienhelin.project.service.orders.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = OrderController.ORDER_RESOURCE_PATH)
public class OrderController {

    public static final String ORDER_RESOURCE_PATH = "/order";
    private final Logger orderLogger = LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<OrderDto> getAllOrders() {
        orderLogger.info("getAllOrders");
        return orderService.getAllOrders();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin(origins = "http://localhost:4200")
    public OrderDto addAnOrder(
            @RequestBody OrderDto orderDto) {
        orderLogger.info("addAnOrder");
        return orderService.addAnOrder(orderDto);
    }
}
