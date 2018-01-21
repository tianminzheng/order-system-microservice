package com.tianyalan.microservice.order.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tianyalan.microservice.order.order.domain.UserOrder;
import com.tianyalan.microservice.order.order.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public List<UserOrder> saveProduct(@RequestBody UserOrder order) {
		orderService.addOrder(order);
		
		List<UserOrder> orders = orderService.getOrders(1,  20);
		return orders;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserOrder getProduct(@PathVariable Long id) {
		UserOrder order = orderService.getOrderById(id);
    	return order;
    }
}
