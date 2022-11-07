package com.comprasapi.icligo.DAO;

import com.comprasapi.icligo.models.Product_type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductType extends JpaRepository<Product_type, Long> {
}
