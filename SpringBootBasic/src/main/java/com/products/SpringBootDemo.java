package com.products;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication(scanBasePackages={"com.products"})
class SpringBootDemo {
	public static void main(String [] args){
		SpringApplication.run(SpringBootDemo.class, args);
	}
}
