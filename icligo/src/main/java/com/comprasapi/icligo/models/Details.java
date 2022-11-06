package com.comprasapi.icligo.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


/**
 * Class defining the structure of the Details of a Purchase
 */
@Data //coloca getters/setters/constructores etc
@Entity
@Table(name = "detail")
public class Details {

    /**
     * identifier of the Detail
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //id_detail is auto incremented
    @Column(name = "id_detail")
    private Long id_detail;

    /**
     * Description
     */
    @NotBlank(message = "Please add a description")
    @Column(name = "description", length = 45, nullable = false)
    private String description;

    /**
     * Quantity purchased
     */
    @Column(name = "quantity", nullable = false)
    private int quantity;

    /**
     * Value of the purchase
     */
    @Column(name = "value", nullable = false)
    private double value;

    @Override
    public String toString() {
        return "Description of purchase: " +  description + ". Amount purchased: " + quantity + " with a total value of " + value;
    }

}
