package com.sapient;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication(scanBasePackages={"com.sapient"})
class SpringBootDemo {
	public static void main(String [] args){
		SpringApplication.run(SpringBootDemo.class, args);
	}
}
