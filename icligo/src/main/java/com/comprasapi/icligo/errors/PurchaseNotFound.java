package com.comprasapi.icligo.errors;

public class PurchaseNotFound extends Exception{

    public PurchaseNotFound(Long id_purchase) {
        super("Purchase with id " + id_purchase + " does not exist");
    }
}
