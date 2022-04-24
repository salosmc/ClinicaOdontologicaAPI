package com.example.ApiRestClinica.exceptions;

import org.apache.log4j.Logger;

public class ResourceNotFoundException extends Exception {

    private static final Logger logger = Logger.getLogger(ResourceNotFoundException.class);

    public ResourceNotFoundException(String message){
        super(message);
        logger.error(message);
    }
}
