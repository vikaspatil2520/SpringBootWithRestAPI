package com.practice.springbootbasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringbootbasicsApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringbootbasicsApplication.class, args);
		
		/*
		 * ApplicationContext ctx =
		 * SpringApplication.run(SpringbootbasicsApplication.class, args);
		 * 
		 * String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
		 * 
		 * for(String beanName:beanDefinitionNames) { System.out.println(beanName); }
		 */
		System.out.println("Shree");
	}

}
