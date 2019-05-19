package com.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.products.Product;
import com.products.ProductService;

@RestController
@RequestMapping("/")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products= productService.getAllProducts();
		return ResponseEntity.ok().body(products);
	}
	
	@RequestMapping(value="/products/{productType}",method=RequestMethod.GET)
	public ResponseEntity getProducts(@PathVariable String productType){
		List<Product> products= productService.getProducts(productType);
		if(products.isEmpty())
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok().body(products);
	}
	
	@RequestMapping(value="/products/{productId}",method=RequestMethod.DELETE)
	public ResponseEntity deleteProduct(@PathVariable Integer productId){
		boolean deleted= productService.deleteProduct(productId);
		if(!deleted)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public ResponseEntity createProduct(@RequestBody Product product){
		productService.addProduct(product);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}