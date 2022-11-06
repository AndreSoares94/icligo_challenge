package com.comprasapi.icligo.errors;

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
    public Map<String, String> handleDetailException(DetailNotFound ex){
        Map<String, String> errorMap  = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(PurchaseNotFound.class)
    public String handlePurchaseException(PurchaseNotFound ex){
        return ex.getMessage();
    }
}
