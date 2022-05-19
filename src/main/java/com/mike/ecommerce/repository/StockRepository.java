package com.mike.ecommerce.repository;

import com.mike.ecommerce.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Integer> {

    List<Stock> findAllByProductUuid_ProductUuid(String productUuid);

}
