package com.mike.ecommerce.repository;

import com.mike.ecommerce.model.CurrencyConversion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversion, Integer> {
}
