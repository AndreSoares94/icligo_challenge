package com.comprasapi.icligo.errors;

import com.comprasapi.icligo.models.Product_type;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DetailNotFound.class)
    public String handleDetailException(DetailNotFound ex){
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(PurchaseNotFound.class)
    public String handlePurchaseException(PurchaseNotFound ex){
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ProductTypeNotFound.class)
    public String handleProductTypeException(ProductTypeNotFound ex){
        return ex.getMessage();
    }

}
