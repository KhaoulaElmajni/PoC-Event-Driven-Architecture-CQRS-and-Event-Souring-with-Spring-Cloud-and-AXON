package me.elmajni.customerqueryside.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.elmajni.coreapi.events.CustomerCreatedEvent;
import me.elmajni.customerqueryside.entities.Customer;
import me.elmajni.customerqueryside.repositories.CustomerRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerEventHandler {
    private CustomerRepository customerRepository;


    @EventHandler
    public void on(CustomerCreatedEvent event) {
        Customer customer = new Customer();
        customer.setId(event.getId());
        customer.setName(event.getName());
        customer.setEmail(event.getEmail());

        customerRepository.save(customer);
    }


}
