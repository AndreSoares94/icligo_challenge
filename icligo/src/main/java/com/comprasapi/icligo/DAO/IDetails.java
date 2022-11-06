package com.comprasapi.icligo.DAO;

import com.comprasapi.icligo.models.Details;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetails extends JpaRepository<Details, Long> {
}
