package me.elmajni.customerqueryside.repositories;

import me.elmajni.customerqueryside.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}

