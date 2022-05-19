package com.mike.ecommerce.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ProductsExceptions extends RuntimeException{

    public ProductsExceptions(String message){
        super(message);
    }

}
