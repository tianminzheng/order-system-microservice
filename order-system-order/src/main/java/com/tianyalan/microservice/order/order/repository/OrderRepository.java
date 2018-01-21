package com.tianyalan.microservice.order.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tianyalan.microservice.order.order.domain.UserOrder;

public interface OrderRepository extends JpaRepository<UserOrder, Long> {

}
