package com.mike.ecommerce.service;

import com.mike.ecommerce.exception.ProductsExceptions;
import com.mike.ecommerce.model.ProductEntity;
import com.mike.ecommerce.repository.CategoriesRepository;
import com.mike.ecommerce.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductsService {

    private final ProductsRepository workingProductRepository;
    private final CategoriesRepository workingCategoriesRepository;

    @Autowired
    public ProductsService(ProductsRepository workingProductRepository, CategoriesRepository workingCategoriesRepository) {
        this.workingProductRepository = workingProductRepository;
        this.workingCategoriesRepository = workingCategoriesRepository;
    }

    public void save(ProductEntity recievedProduct) {
        workingProductRepository.save(recievedProduct);
    }

    public void delete(Integer receivedProductId){
        workingProductRepository.deleteById(receivedProductId);
    }

    public ResponseEntity<ProductEntity> getById(Integer receivedId){
        System.out.println("Here");
        ProductEntity product = workingProductRepository.findByProductId(receivedId);
        System.out.println(product.toString());
        if(product == null) {
           throw new ProductsExceptions("Product does not exist with id: " + receivedId);
        }

        return  ResponseEntity.ok(product);
    }

    public String getProductNameByUuid(String receivedUuid){
        String productName = workingProductRepository.getByProductUuid(receivedUuid).getProductName();
        if(productName == null) {
            throw new ProductsExceptions("Product does not exist with id: " + receivedUuid);
        }
        return  productName;
    }

    public ResponseEntity update(Integer updateProductId, ProductEntity receivedProductToUpdate){
        ProductEntity updateProduct = workingProductRepository.findById(updateProductId)
                .orElseThrow(() -> new ProductsExceptions("Product does not exist with id: " + updateProductId));

        updateProduct.setProductName(receivedProductToUpdate.getProductName());
        updateProduct.setProductDescription(receivedProductToUpdate.getProductDescription());
        updateProduct.setProductImage(receivedProductToUpdate.getProductImage());
        updateProduct.setProductPrice(receivedProductToUpdate.getProductPrice());
        updateProduct.setCategoriesList(receivedProductToUpdate.getCategoriesList());

        workingProductRepository.save(updateProduct);

        return ResponseEntity.ok(updateProduct);
    }

    public ResponseEntity<List<ProductEntity>> getProductsByCategory(String tagCategoryName) {
            List<ProductEntity> retrivedCategoryProducts = workingProductRepository.findAllByCategoriesListContaining(workingCategoriesRepository.findByCategoryName(tagCategoryName));
                    if(retrivedCategoryProducts.size()<1) {
                        try {
                            throw new ProductsExceptions(tagCategoryName + " has no products");
                        } catch (Exception ProductsException) {
                           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ProductsException.getMessage());
                        }
                    }
            return new ResponseEntity<>(retrivedCategoryProducts, HttpStatus.OK);
    }

}
