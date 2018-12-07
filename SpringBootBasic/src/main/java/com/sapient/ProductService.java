package com.sapient;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sapient.Product;
@Service
public interface ProductService {
	List<Product> getAllProducts();
	List<Product> getProducts(String productType);
	void addProduct(Product product);
	boolean deleteProduct(Integer productId);
}
