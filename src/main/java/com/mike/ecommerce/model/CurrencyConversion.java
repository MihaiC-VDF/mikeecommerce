package com.mike.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "currencyConversion")
public class CurrencyConversion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "providedCurrency", length = 3)
    private String providedCurrency;

    @Column(name = "targetCurrency", length = 3)
    private String targetCurrency;

    @Column(name = "conversion")
    private double conversion;

}