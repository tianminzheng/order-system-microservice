package com.tianyalan.microservice.order.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tianyalan.microservice.order.order.domain.UserOrder;
import com.tianyalan.microservice.order.order.repository.OrderRepository;
import com.tianyalan.microservice.order.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void addOrder(UserOrder order) {
		orderRepository.save(order);
	}

	@Override
	public List<UserOrder> getOrders(int pageIndex, int pageSize) {
		return orderRepository.findAll(new PageRequest(pageIndex - 1, pageSize)).getContent();
	}

	@Override
	public UserOrder getOrderById(Long id) {
		return orderRepository.findOne(id);
	}

}
