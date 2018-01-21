package com.tianyalan.microservice.order.gateway.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianyalan.microservice.order.gateway.domain.Order;

@FeignClient("order")
public interface OrderService {
	@RequestMapping(method = RequestMethod.POST, value = "/save", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	List<Order> save(@RequestBody Order order);
}




