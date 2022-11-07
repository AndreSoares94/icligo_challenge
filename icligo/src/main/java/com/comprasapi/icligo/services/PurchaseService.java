package com.comprasapi.icligo.services;

import com.comprasapi.icligo.DAO.IDetails;
import com.comprasapi.icligo.DAO.IProductType;
import com.comprasapi.icligo.DAO.IPurchase;
import com.comprasapi.icligo.errors.DetailNotFound;
import com.comprasapi.icligo.errors.ProductTypeNotFound;
import com.comprasapi.icligo.errors.PurchaseNotFound;
import com.comprasapi.icligo.models.Details;
import com.comprasapi.icligo.models.Product_type;
import com.comprasapi.icligo.models.Purchase;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    private IPurchase purchasedao;
    private IProductType product_type_dao;

    // em vez de autowired, fazemos construtor para autoinjeçao de dependencias
    public PurchaseService(IPurchase purchasedao, IProductType product_type_dao){
        this.purchasedao = purchasedao;
        this.product_type_dao = product_type_dao;
    }

    /**
     * Gets list of strings of all purchases in DB
     * @return list of strings with info of all purchases
     */
    public List<String> getAllPurchases(){
        List<Purchase> list_purchases = purchasedao.findAll();
        List<String> list = new ArrayList<>();
        for (Purchase purchase : list_purchases) {
            String s = new String(purchase.toString());
            list.add(s);
        }
        return list;
    }

    /**
     * Get purchase identified by id
     * @param id identifier
     * @return returns the purchase
     */
    public Purchase getPurchase(Long id) throws PurchaseNotFound {
        Purchase purchase = purchasedao.findById(id).orElseThrow(() -> new PurchaseNotFound(id));
        return purchase;
    }

    public List<Purchase> getPurchasebyType(Long id) throws ProductTypeNotFound {
        Product_type ptype = product_type_dao.findById(id).orElseThrow(() -> new ProductTypeNotFound(id));
        List<Purchase> list = purchasedao.findByProductTypeID(id);
        return list;
    }

    /**
     * Get all purchases with expiring date higher than NOW()
     * @return
     */
    public List<Purchase> getValidPurchases(){
        List<Purchase> list = purchasedao.findByDateGreaterThanEqual();
        return list;
    }

    /**
     * Creates new Purchase
     * @param purchase to add to DB
     * @return purchase added
     */
    public Purchase newPurchase(Purchase purchase){
        Purchase newPurchase = purchasedao.save(purchase);
        return newPurchase;
    }

    /**
     * Given a Purchase, it updates its fields
     * @param purchase
     * @return purchase updates
     * @throws PurchaseNotFound if theres is not Purchase with the id of the purchase to update
     */
    public Purchase updatePurchase(Purchase purchase) throws PurchaseNotFound {
        Purchase oldPurchase = purchasedao.findById(purchase.getId_purchase()).orElseThrow(() -> new PurchaseNotFound(purchase.getId_purchase()));
        oldPurchase.setDetails(purchase.getDetails());
        oldPurchase.setExpires(purchase.getExpires());
        oldPurchase.setProduct_type(purchase.getProduct_type());

        purchasedao.save(oldPurchase);
        return oldPurchase;
    }

    /**
     * Deletes the Purchase identified by the id
     * @param id identifier of the purchase
     * @return true if deleted successfully
     */
    public Boolean deletePurchase(Long id) throws PurchaseNotFound{
        Purchase purchasetodelete = purchasedao.findById(id).orElseThrow(() -> new PurchaseNotFound(id));
        purchasedao.deleteById(id);
        return true;
    }
}
