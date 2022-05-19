package com.mike.ecommerce.controller;


import com.mike.ecommerce.model.ProductEntity;
import com.mike.ecommerce.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/products")
@PermitAll
public class ProductsController {

    private final ProductsService workingProductsService;

    @Autowired
    public ProductsController(ProductsService workingProductsService) {
        this.workingProductsService = workingProductsService;
    }

    @PostMapping
    public String save(@Valid @RequestBody ProductEntity receivedProduct) {
        workingProductsService.save(receivedProduct);
        return (receivedProduct.getProductName()+" has been saved successfully");
//        return new HttpServletResponse(200, receivedProduct.getProductName()+" has been saved successfully");
    }

    @DeleteMapping("/{id}")
    public void delete(@NotNull @PathVariable("id") Integer id) {
        workingProductsService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> update(@Valid @NotNull @PathVariable("id") Integer id,
                                                @Valid @RequestBody ProductEntity receivedProduct) {

        return workingProductsService.update(id, receivedProduct);
    }

    @GetMapping("/isbn")
    public ResponseEntity<ProductEntity> getById
            (@Valid @NotNull @RequestParam Integer id) {
        return workingProductsService.getById(id);
    }

    @GetMapping("/categoryName")
    public ResponseEntity<List<ProductEntity>> getProductsForCategory (
            @Valid @NotNull @RequestParam String categoryName){
        return workingProductsService.getProductsByCategory(categoryName);
    }




}
