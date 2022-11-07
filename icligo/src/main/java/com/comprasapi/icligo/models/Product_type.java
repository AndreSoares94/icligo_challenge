package com.comprasapi.icligo.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Class defining the structure of the type of a product
 */
@Data
@Entity
@Table(name = "product_type")
public class Product_type {

    /**
     * identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //id_detail is auto incremented
    @Column(name = "id_product_type")
    private Long id_product_type;

    /**
     * Type of product description
     */
    @NotBlank(message = "Please add a product type")
    @Column(name = "type_description", length = 45, nullable = false)
    private String type_description;

}
