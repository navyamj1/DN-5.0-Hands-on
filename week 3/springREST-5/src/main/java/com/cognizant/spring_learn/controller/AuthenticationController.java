package com.cognizant.spring_learn.controller;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



@RestController
public class AuthenticationController {
	 private static final Logger LOGGER =LoggerFactory.getLogger(AuthenticationController.class);
	@GetMapping("/authenticate")
	public Map<String,String> authenticate(@RequestHeader("Authorization")String authHeader){
	LOGGER.info("START");
	LOGGER.debug(authHeader);
	String user=getUser(authHeader);
	LOGGER.debug("Authenticated User: {}", user);
	String token=generateJwt(user);
	
	Map<String,String> map=new HashMap<>();
	map.put("token", token);
	LOGGER.info("END");
    return map;    
	}
	private String getUser(String authHeader) {
		LOGGER.info("START getUser()");
		String encodedCredentials=authHeader.substring(6);
		 LOGGER.debug("Encoded Credentials: {}", encodedCredentials);
		 byte[] decodedBytes=Base64.getDecoder().decode(encodedCredentials);
		 String credentials = new String(decodedBytes, StandardCharsets.UTF_8);
		 
		String user = credentials.substring(0, credentials.indexOf(":"));
		 LOGGER.debug("User: {}", user);

		 LOGGER.info("End getUser()");

		 return user;
	}
	private String generateJwt(String user) {
		LOGGER.info("Start generateJwt()");
		JwtBuilder builder=Jwts.builder();
		builder.setSubject(user);
		builder.setIssuedAt(new Date());
		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256,"secret key");
		 String token = builder.compact();
		 LOGGER.debug("Generated Token: {}", token);
		 LOGGER.info("End generateJwt()");
		 return token;
	}
}
