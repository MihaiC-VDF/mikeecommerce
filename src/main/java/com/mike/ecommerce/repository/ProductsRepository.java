package com.mike.ecommerce.repository;

import com.mike.ecommerce.model.CategoriesEntity;
import com.mike.ecommerce.model.ProductEntity;
import com.mike.ecommerce.service.ProductsService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<ProductEntity, Integer> {

    List<ProductEntity> findAllByCategoriesListContaining(CategoriesEntity searchedTag);

    ProductEntity findByProductId(Integer receivedId);

    ProductEntity getByProductUuid(String productUuid);

}
