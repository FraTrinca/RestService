package com.nttdata.restservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.ZonedDateTime;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> genericErrorLaunch(RestRequestException err) {
        err.getMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(err, status);
    }

    @ExceptionHandler(value = {RestRequestException.class})
    public ResponseEntity<Object> idNotFound(RestRequestException err) {
        err.getClass().getSimpleName();
        err.getMessage();
        return new ResponseEntity<>(err + "\n NESSUN PLAYER CORRISPONDE A QUESTO ID ", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<Object> HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException err) {
        err.getMessage();
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(err + "\n STAI CHIAMANDO IL METODO IN MODO ERRATO: controlla come hai inserito i dati o se l'url è scritto correttamente", status);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<Object> IllegalArgumentException(IllegalArgumentException err) {
        err.getClass().getSimpleName();
        err.getMessage();
        return new ResponseEntity<>(err + "\n CONTROLLA I PARAMETRI INSERITI, NON SONO CORRETTI ", HttpStatus.NOT_FOUND);
    }
}


