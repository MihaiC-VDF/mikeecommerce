package com.mike.ecommerce.repository;

import com.mike.ecommerce.model.ExpiredStock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ExpiredStockRepository extends JpaRepository<ExpiredStock, Integer> {

    public void deleteByStockExpirationIsBefore(LocalDate beforeDate);

    public void deleteByProductUuid(String productUuid);

}
