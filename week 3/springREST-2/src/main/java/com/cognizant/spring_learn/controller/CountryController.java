package com.cognizant.spring_learn.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import 
org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cognizant.spring_learn.Country;
import com.cognizant.spring_learn.service.CountryService;
@RestController
public class CountryController {
	public static final Logger LOGGER=LoggerFactory.getLogger(CountryController.class);
	@RequestMapping ("/country")
	public Country getCountryIndia() {
		LOGGER.info("START");
		ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("Country.xml");
		Country country=context.getBean("country",Country.class);
		context.close();
		LOGGER.info("END");
		return country;
	}
	@Autowired
	private CountryService countryService;
	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable String code) {
		return countryService.getCountry(code);
		
	}
}
