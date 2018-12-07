package com.sapient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.Product;
import com.sapient.ProductService;

@RestController
@RequestMapping("/")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="/product",method=RequestMethod.GET)
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products= productService.getAllProducts();
		return ResponseEntity.ok().body(products);
	}
	
	@RequestMapping(value="/product/{productType}",method=RequestMethod.GET)
	public ResponseEntity getProducts(@PathVariable String productType){
		List<Product> products= productService.getProducts(productType);
		if(products.isEmpty())
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok().body(products);
	}
	
	@RequestMapping(value="/product/{productId}",method=RequestMethod.DELETE)
	public ResponseEntity deleteProduct(@PathVariable Integer productId){
		boolean deleted= productService.deleteProduct(productId);
		if(!deleted)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value="/product",method=RequestMethod.POST)
	public ResponseEntity createProduct(@RequestBody Product product){
		productService.addProduct(product);
		return ResponseEntity.ok().build();
	}
}
