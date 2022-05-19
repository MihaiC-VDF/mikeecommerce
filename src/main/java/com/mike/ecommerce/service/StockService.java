package com.mike.ecommerce.service;


import com.mike.ecommerce.model.Stock;
import com.mike.ecommerce.repository.ExpiredStockRepository;
import com.mike.ecommerce.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StockService {

    private final StockRepository workingStockRepository;

    private final ExpiredStockRepository workingExpiredStockRepository;

    @Autowired
    public StockService(StockRepository workingStockRepository, ExpiredStockRepository workingExpiredStockRepository) {
        this.workingStockRepository = workingStockRepository;
        this.workingExpiredStockRepository = workingExpiredStockRepository;
    }

    public void deleteAllExpiredStock() {
        workingExpiredStockRepository.deleteByStockExpirationIsBefore(LocalDate.now());
    }

    public void deleteStockExpireDateBefore(LocalDate dateBefore){
        workingExpiredStockRepository.deleteByStockExpirationIsBefore(dateBefore);
    }

    public void deleteExpiredStockById(String productUuid){
        workingExpiredStockRepository.deleteByProductUuid(productUuid);
    }

    public List<Stock> allStockForProduct(String productUuid){
        return workingStockRepository.findAllByProductUuid_ProductUuid(productUuid);
    }

    public void saveNewStock(Stock receivedStock){
        workingStockRepository.save(receivedStock);
    }
}
