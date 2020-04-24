package be.adrienhelin.project.service.customers;

import be.adrienhelin.project.domain.customers.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDto register(CustomerDto customerDto) {
        return customerMapper.toDto(customerRepository.save(customerMapper.toCustomer(customerDto)));
    }

    public Collection<CustomerDto> getAllCustomers() {
        return customerMapper.toDto(customerRepository.findAll());
    }

}
