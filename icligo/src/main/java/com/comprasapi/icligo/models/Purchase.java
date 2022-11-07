package com.comprasapi.icligo.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

/**
 * Class defining the structure of a Purchase
 */
@Data //coloca getters/setters/constructores etc
@Entity
@Table(name = "purchase")
public class Purchase {

    /**
     * identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //id_detail is auto incremented
    @Column(name = "id_purchase")
    private Long id_purchase;

    /**
     * Type of product
     */
    @ManyToOne
    @JoinColumn(name="product_type_fk", referencedColumnName = "id_product_type")
    private Product_type product_type;

    /**
     * Expiration date
     */
    @Column(name = "expires", nullable = false)
    private LocalDateTime expires;

    /**
     * Object Details of purchase
     */
    @OneToOne
    @JoinColumn(name = "id_detail_fk", referencedColumnName = "id_detail")
    private Details details;

}
