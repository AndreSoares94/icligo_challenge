package com.comprasapi.icligo.controllers;

import com.comprasapi.icligo.errors.ProductTypeNotFound;
import com.comprasapi.icligo.errors.PurchaseNotFound;
import com.comprasapi.icligo.models.Details;
import com.comprasapi.icligo.models.Purchase;
import com.comprasapi.icligo.services.PurchaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    private PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService){
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public ResponseEntity<List<Purchase>> listPurchases(){
        return ResponseEntity.status(200).body(purchaseService.getAllPurchases());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Purchase> getPurchasebyID(@PathVariable Long id) throws PurchaseNotFound {
        return ResponseEntity.status(200).body(purchaseService.getPurchase(id));
    }

    @GetMapping("/type/{id}")
    public ResponseEntity<List<Purchase>> getPurchasebyTypeID(@PathVariable Long id) throws ProductTypeNotFound {
        return ResponseEntity.status(200).body(purchaseService.getPurchasebyType(id));
    }

    @GetMapping("/validPurchase")
    public ResponseEntity<List<Purchase>> getValidPurchases() {
        return ResponseEntity.status(200).body(purchaseService.getValidPurchases());
    }

    @PostMapping
    public ResponseEntity<Purchase> createPurchase(@RequestBody @Valid Purchase purchase){
        return ResponseEntity.status(201).body(purchaseService.newPurchase(purchase));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Purchase> updatePurchase(Long id, @RequestBody @Valid Purchase purchase) throws PurchaseNotFound {
        return ResponseEntity.status(201).body(purchaseService.updatePurchase(id, purchase));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePurchase(@PathVariable Long id) throws PurchaseNotFound {
        purchaseService.deletePurchase(id);
        return ResponseEntity.status(204).build();
    }

}
