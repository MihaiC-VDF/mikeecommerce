package com.mike.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@AllArgsConstructor
@Setter
@Getter
@Table(name = "products")
public class ProductEntity implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "productId", nullable = false)
    private Integer productId;


    @Column(name = "productUuid", nullable = false)
    private String productUuid;

    @Column(name = "productName", nullable = false)
    private String productName;

    @Column(name = "productDescription")
    private String productDescription;

    @Column(name = "productImage")
    private String productImage;

    @Column(name = "productPrice")
    private Double productPrice;

    @Column(name = "currency")
    private String currency;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "products_categories",
            joinColumns = {
                    @JoinColumn(name = "productUuid", referencedColumnName = "productUuid",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId",
                            nullable = false, updatable = false)})
    private Set<CategoriesEntity> categoriesList = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "productUuid")
//    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Stock> stocks = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "productUuid")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<ExpiredStock> expiredStocks = new HashSet<>();

    public ProductEntity() {
        this.productUuid = UUID.randomUUID().toString();
    }

    public ProductEntity(String productName, String productDescription, String productImage, Double productPrice) {
        this.productUuid = UUID.randomUUID().toString();
        this.productName = productName;
        this.productDescription = productDescription;
        this.productImage = productImage;
        this.productPrice = productPrice;
    }
                  }