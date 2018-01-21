package com.tianyalan.microservice.order.customer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyalan.microservice.order.customer.domain.Customer;
import com.tianyalan.microservice.order.customer.repository.CustomerRepository;
import com.tianyalan.microservice.order.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;


	@Override
	public Customer getCustomerById(Long customerId) {
		return customerRepository.findOne(customerId);
	}

}
