package com.tianyalan.microservice.order.order.service;

import java.util.List;

import com.tianyalan.microservice.order.order.domain.UserOrder;

public interface OrderService {

	void addOrder(UserOrder order);
	
	List<UserOrder> getOrders(int pageIndex, int pageSize);
	
	UserOrder getOrderById(Long id);
}
