package com.gl.app.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
/*
    it is a custom exception class to handle the exception
    when a valid user is not linked with a valid product in the table
 */
@Getter
public class FoodServiceApiException extends RuntimeException {
    private HttpStatus httpStatus;
    private String message;

    public FoodServiceApiException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
