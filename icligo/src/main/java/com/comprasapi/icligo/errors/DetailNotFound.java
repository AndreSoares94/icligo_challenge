package com.comprasapi.icligo.errors;

public class DetailNotFound extends Exception{

    public DetailNotFound(Long id_detail) {
        super("Detail with id " + id_detail + " does not exist");
    }
}
