package be.adrienhelin.project.service.customers;

import be.adrienhelin.project.domain.customers.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDto register(CustomerDto customerDto) {
        return customerMapper.toDto(customerRepository.register(customerMapper.toCustomer(customerDto)));
    }

    public Collection<CustomerDto> getAllCustomers() {
        return customerMapper.toDto(customerRepository.getAllCustomers());
    }

}
