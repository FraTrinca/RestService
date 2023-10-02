package com.nttdata.restservice.exception;

import org.springframework.http.HttpStatus;

public class RestRequestException extends RuntimeException{

    //Prende una stringa e la passa alla super classe RuntimeException
    public RestRequestException(String message, HttpStatus status) {
        super(message);
    }
}




