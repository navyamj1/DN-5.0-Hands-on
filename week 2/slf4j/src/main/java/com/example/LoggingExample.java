package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public void doaction(String user) {
        
        logger.info("user {} logged in", user);
        logger.debug("debug detail for {}", user);
        logger.warn("this is a warning");
        logger.error("this is an error message");
    }

    public static void main(String[] args) {
        new LoggingExample().doaction("tom");
    }
}
