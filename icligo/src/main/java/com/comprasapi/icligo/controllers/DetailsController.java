package com.comprasapi.icligo.controllers;

import com.comprasapi.icligo.errors.DetailNotFound;
import com.comprasapi.icligo.errors.PurchaseNotFound;
import com.comprasapi.icligo.models.Details;
import com.comprasapi.icligo.services.DetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/details")
public class DetailsController {

    private DetailsService detailsService;

    public DetailsController(DetailsService detailsService){
        this.detailsService = detailsService;
    }

    @GetMapping
    public ResponseEntity<List<Details>> listDetails(){
        return ResponseEntity.status(200).body(detailsService.getAllDetails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Details> getDetailbyID(@PathVariable Long id) throws DetailNotFound {
        return ResponseEntity.status(200).body(detailsService.getDetail(id));
    }

    @PostMapping
    public ResponseEntity<Details> createDetails(@RequestBody @Valid Details details){
        return ResponseEntity.status(201).body(detailsService.newDetail(details));
    }

    @PutMapping
    public ResponseEntity<Details> updateDetails(@RequestBody Details details) throws PurchaseNotFound {
        return ResponseEntity.status(201).body(detailsService.updateDetail(details));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDetails(@PathVariable Long id) throws DetailNotFound {
        detailsService.deleteDetail(id);
        return ResponseEntity.status(204).build();
    }
}

