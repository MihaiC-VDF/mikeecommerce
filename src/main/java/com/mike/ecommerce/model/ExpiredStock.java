package com.mike.ecommerce.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "expiredStock")
public class ExpiredStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "stockExpiration")
    private LocalDate stockExpiration;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productUuid", referencedColumnName = "productUuid")
    private ProductEntity productUuid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getStockExpiration() {
        return stockExpiration;
    }

    public void setStockExpiration(LocalDate stockExpiration) {
        this.stockExpiration = stockExpiration;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductEntity getProductUuid() {
        return productUuid;
    }

    public void setProductUuid(ProductEntity productUuid) {
        this.productUuid = productUuid;
    }

}