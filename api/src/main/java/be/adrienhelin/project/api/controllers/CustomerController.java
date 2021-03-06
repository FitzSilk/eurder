package be.adrienhelin.project.api.controllers;

import be.adrienhelin.project.service.customers.CustomerDto;
import be.adrienhelin.project.service.customers.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "https://eurder-angular-front-end.herokuapp.com")
@RequestMapping(path = CustomerController.CUSTOMER_RESOURCE_PATH)
public class CustomerController {

    public static final String CUSTOMER_RESOURCE_PATH = "/member";
    private final CustomerService customerService;
    private final Logger customerLogger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Collection<CustomerDto> getAllCustomers() {
        customerLogger.info("getAllCustomers");
        return customerService.getAllCustomers();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto getCustomerById(@PathVariable Integer id) {
        customerLogger.info("getCustomerById: " + id);
        return customerService.getCustomerById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto register(@RequestBody CustomerDto customerDto) {
        customerLogger.info("A new customer is registering.");
        return customerService.register(customerDto);
    }
}
