package com.tianyalan.microservice.order.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients 
@EnableCircuitBreaker 
@EnableZuulProxy 
public class GatewayApplication {
	public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}




