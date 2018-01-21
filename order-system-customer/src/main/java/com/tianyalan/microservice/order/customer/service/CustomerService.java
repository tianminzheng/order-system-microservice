package com.tianyalan.microservice.order.customer.service;

import com.tianyalan.microservice.order.customer.domain.Customer;

public interface CustomerService {
	
	Customer getCustomerById(Long customerId);
}
