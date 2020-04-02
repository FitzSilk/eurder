package be.adrienhelin.project.service.customers;

import be.adrienhelin.project.domain.customers.Customer;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

import static be.adrienhelin.project.domain.customers.CustomerBuilder.customerBuilder;

@Component
public class CustomerMapper {

    public CustomerDto toDto(Customer customer) {
        return new CustomerDto(customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPassword(),
                customer.getPhoneNumber(),
                customer.getAddress());
    }

    public Collection<CustomerDto> toDto(Collection<Customer> customerCollection) {
        return customerCollection.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Customer toCustomer(CustomerDto customerDto) {
        return customerBuilder()
                .withFirstName(customerDto.getFirstName())
                .withLastName(customerDto.getLastName())
                .withEmail(customerDto.getEmail())
                .withPassword(customerDto.getPassword())
                .withPhoneNumber(customerDto.getPhoneNumber())
                .withAddress(customerDto.getAddress())
                .build();
    }
}
