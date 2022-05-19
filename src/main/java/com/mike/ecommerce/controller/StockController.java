package com.mike.ecommerce.controller;


import com.mike.ecommerce.model.Stock;
import com.mike.ecommerce.service.ProductsService;
import com.mike.ecommerce.service.StockService;
import io.swagger.annotations.Authorization;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/stock")
@PermitAll
public class StockController {

    private final StockService workingStockService;

    private final ProductsService workingProductService;

    public StockController(StockService workingStockService, ProductsService workingProductService) {
        this.workingStockService = workingStockService;
        this.workingProductService = workingProductService;
    }

    @PostMapping("/addStock")
    public String addStock(@Valid @RequestBody Stock receivedStock){
        String responseMessage = ("Stock for " + receivedStock.getProductUuid().getProductName() + " has been added");
        workingStockService.saveNewStock(receivedStock);
        return responseMessage;
    }

    @GetMapping("/")
    public ResponseEntity<List<Stock>> returnAllStock(@RequestParam String productUuid){
        return new ResponseEntity<>(workingStockService.allStockForProduct(productUuid), HttpStatus.OK);
    }

    @DeleteMapping("/cleanexpiredstock")
    public String deleteAllExpiredStock() {
        workingStockService.deleteAllExpiredStock();
        String message = "Warehouse has been cleaned of expired stock";
        return message;
    }

}
