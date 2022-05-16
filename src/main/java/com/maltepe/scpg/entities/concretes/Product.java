package com.maltepe.scpg.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Product  {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotNull
    @NotEmpty
    @Size(min = 2)
    @Column(name = "product_name")
    private String productName;


    @NotNull
    @Min(1)
    @Column(name = "unit_price")
    private double unitPrice;

    @Min(1)
    @NotNull
    @Column(name = "units_in_stock")
    private int unitsInStock;


    @ManyToOne
    @NotNull
    private Category category;

}
