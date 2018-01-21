package com.tianyalan.microservice.order.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tianyalan.microservice.order.product.domain.Product;
import com.tianyalan.microservice.order.product.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/{productCode}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable String productCode) {
		Product product = productService.getProductByCode(productCode);
		
    	return product;
    }
}
