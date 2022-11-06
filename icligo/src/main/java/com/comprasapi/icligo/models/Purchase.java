package com.comprasapi.icligo.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

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
    @NotBlank(message = "Please add a product type")
    @Column(name = "product_type", length = 45, nullable = false)
    private String product_type;

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

    @Override
    public String toString() {
        return "Purchase with id " +  id_purchase + " has product type: " + product_type + " with expiration date in " +
                expires.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)) +  ". More details: " + details;
    }
}
