package be.adrienhelin.project.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = UserController.USER_RESOURCE_PATH)
public class UserController {

    public static final String USER_RESOURCE_PATH = "/member";

    @Autowired
    public UserController() {

    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String helloWorld() {
        return "Hello World!";
    }
}
