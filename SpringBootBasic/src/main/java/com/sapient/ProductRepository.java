package com.sapient;

import org.springframework.stereotype.Repository;

import com.sapient.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product,Integer>{
	List<Product> findByProductType(String productType);
}
