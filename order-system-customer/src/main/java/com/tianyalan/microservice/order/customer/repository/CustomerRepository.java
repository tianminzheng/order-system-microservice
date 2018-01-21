package com.tianyalan.microservice.order.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tianyalan.microservice.order.customer.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
