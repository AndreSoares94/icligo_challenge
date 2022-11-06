package com.comprasapi.icligo.DAO;

import com.comprasapi.icligo.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IPurchase extends JpaRepository<Purchase, Long> {

    @Query(value = "SELECT * FROM purchase WHERE expires >= now()",
            nativeQuery = true)
    List<Purchase> findByDateGreaterThanEqual();
}
