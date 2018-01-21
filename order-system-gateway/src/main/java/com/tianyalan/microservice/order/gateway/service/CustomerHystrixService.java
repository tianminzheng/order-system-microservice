package com.tianyalan.microservice.order.gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tianyalan.microservice.order.gateway.domain.Customer;

@Service
public class CustomerHystrixService {
	
	@Autowired
	RestTemplate restTemplate; 

	@HystrixCommand(fallbackMethod = "fallbackCustomer") 
	public Customer getCustomer(Long customerId) {
		return restTemplate.getForObject("http://Customer/" + 
				customerId, Customer.class);
	}
	
	public Customer fallbackCustomer(Long customerId){ 
		Customer customer = new Customer();
		customer.setDescription(customerId + ": Customer service failed!");
		return customer;
	}	
}



