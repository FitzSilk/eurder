package be.adrienhelin.project.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = CustomerController.CUSTOMER_RESOURCE_PATH)
public class CustomerController {

    public static final String CUSTOMER_RESOURCE_PATH = "/member";

    @Autowired
    public CustomerController() {

    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String helloWorld() {
        return "Hello World!";
    }
}
