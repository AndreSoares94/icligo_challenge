package com.comprasapi.icligo.controllers;

import com.comprasapi.icligo.errors.DetailNotFound;
import com.comprasapi.icligo.errors.ProductTypeNotFound;
import com.comprasapi.icligo.errors.PurchaseNotFound;
import com.comprasapi.icligo.models.Details;
import com.comprasapi.icligo.models.Product_type;
import com.comprasapi.icligo.services.DetailsService;
import com.comprasapi.icligo.services.ProductTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductTypeController {

    private ProductTypeService ptypeService;

    public ProductTypeController(ProductTypeService ptypeService){
        this.ptypeService = ptypeService;
    }

    @GetMapping
    public ResponseEntity<List<Product_type>> listTypes(){
        return ResponseEntity.status(200).body(ptypeService.getAllTypes());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product_type> getTypebyID(@PathVariable Long id) throws ProductTypeNotFound {
        return ResponseEntity.status(200).body(ptypeService.getPType(id));
    }

    @PostMapping
    public ResponseEntity<Product_type> createType(@RequestBody @Valid Product_type ptype){
        return ResponseEntity.status(201).body(ptypeService.newPType(ptype));
    }

    @PutMapping
    public ResponseEntity<Product_type> updateType(@RequestBody @Valid Product_type ptype) throws ProductTypeNotFound {
        return ResponseEntity.status(201).body(ptypeService.updatePType(ptype));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteType(@PathVariable Long id) throws ProductTypeNotFound {
        ptypeService.deletePType(id);
        return ResponseEntity.status(204).build();
    }

}

