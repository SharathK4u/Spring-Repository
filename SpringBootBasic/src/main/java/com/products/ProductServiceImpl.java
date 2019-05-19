package com.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.Product;
import com.products.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public List<Product> getProducts(String productType) {
		List<Product> products = productRepository.findByProductType(productType);
		return products;
	}

	public void addProduct(Product product) {
		productRepository.save(product);
	}

	public boolean deleteProduct(Integer productId) {
		Product product = productRepository.findOne(productId);
		if(product!=null){
			productRepository.delete(productId);
			return true;
		}
		else
			return false;
	}

}
