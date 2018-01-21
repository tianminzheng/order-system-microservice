package com.tianyalan.microservice.order.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianyalan.microservice.order.product.domain.Product;
import com.tianyalan.microservice.order.product.repository.ProductRepository;
import com.tianyalan.microservice.order.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product getProductByCode(String productName) {
		return productRepository.findByProductName(productName);
	}

}
