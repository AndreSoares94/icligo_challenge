package com.comprasapi.icligo.errors;

public class ProductTypeNotFound extends Exception{

    public ProductTypeNotFound(Long id_detail) {
        super("Product Type with id " + id_detail + " does not exist");
    }
}
