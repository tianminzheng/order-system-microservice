package com.tianyalan.microservice.order.gateway.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tianyalan.microservice.order.gateway.base.ResultMessageBuilder;
import com.tianyalan.microservice.order.gateway.base.ResultMessageBuilder.ResultMessage;
import com.tianyalan.microservice.order.gateway.domain.Customer;
import com.tianyalan.microservice.order.gateway.domain.Order;
import com.tianyalan.microservice.order.gateway.domain.Product;
import com.tianyalan.microservice.order.gateway.service.CustomerHystrixService;
import com.tianyalan.microservice.order.gateway.service.OrderHystrixService;
import com.tianyalan.microservice.order.gateway.service.ProductHystrixService;

@RestController
public class GatewayController {

	@Autowired
	private CustomerHystrixService customerHystrixService;
	
	@Autowired
	private OrderHystrixService orderHystrixService;
	
	@Autowired
	private ProductHystrixService productHystrixService;
		
	@RequestMapping("/gateway")
	public ResultMessage gateway(Long customerId, String productCode) throws Exception {
		Customer customer = customerHystrixService.getCustomer(customerId);
		if(customer == null || customer.getDescription().contains("fail")) {
			return ResultMessageBuilder.build(false, 
					"The customer for " + customerId + " is not existed!");
		}
		
		Product product = productHystrixService.getProduct(productCode);
		if(product == null || product.getDescription().contains("fail")) {
			return ResultMessageBuilder.build(false, 
					"The product for " + productCode + " is not existed!");
		}
				
		Order order = new Order();		
		order.setCustomerId(customerId);
		order.setProductCode(productCode);
		order.setCreateTime(new Date());
		List<Order> orders = orderHystrixService.save(order);
		
		return ResultMessageBuilder.build(orders);
	}
}




