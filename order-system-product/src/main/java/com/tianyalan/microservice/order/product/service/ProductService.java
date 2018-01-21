package com.tianyalan.microservice.order.product.service;

import com.tianyalan.microservice.order.product.domain.Product;

public interface ProductService {
	
	Product getProductByCode(String productCode);
}
