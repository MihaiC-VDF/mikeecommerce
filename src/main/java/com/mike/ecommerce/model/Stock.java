package com.mike.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "stockDate")
    private LocalDate stockDate;

    @Column(name = "stockExpiration")
    private LocalDate stockExpiration;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "productUuid", referencedColumnName = "productUuid")
    @JsonIgnore
    private ProductEntity productUuid;


}