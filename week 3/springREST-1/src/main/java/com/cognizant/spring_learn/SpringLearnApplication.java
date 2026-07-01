package com.cognizant.spring_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringLearnApplication {
	public static void displayCountry() {
		ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		Country country=context.getBean("country",Country.class);
		System.out.println(country);
	}
	public static void main(String[] args) {
		System.out.println("Main method started");
		SpringApplication.run(SpringLearnApplication.class, args);
		System.out.println("Application started");
		displayCountry();
	}
	

}
