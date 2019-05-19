package com.products;

import org.springframework.stereotype.Repository;

import com.products.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product,Integer>{
	List<Product> findByProductType(String productType);
}
