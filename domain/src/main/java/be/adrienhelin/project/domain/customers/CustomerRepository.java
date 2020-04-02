package be.adrienhelin.project.domain.customers;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CustomerRepository {

    private final ConcurrentHashMap<String, Customer> customerRepository;

    public CustomerRepository() {
        this.customerRepository = new ConcurrentHashMap<>();
    }

    public Collection<Customer> getAllCustomers() {
        return customerRepository.values();
    }

    public Customer register(Customer customer) {
        return customerRepository.put(customer.getId(), customer);
    }

}
