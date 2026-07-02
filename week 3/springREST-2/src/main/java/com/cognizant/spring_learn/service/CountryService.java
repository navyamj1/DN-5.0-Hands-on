package com.cognizant.spring_learn.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.spring_learn.Country;
import java.util.List;
@Service
public class CountryService{
	public Country getCountry(String code) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries=context.getBean("countryList",List.class);
		return countries.stream().filter(country->country.getCode().equalsIgnoreCase(code)).findFirst().orElse(null);
		
}
}