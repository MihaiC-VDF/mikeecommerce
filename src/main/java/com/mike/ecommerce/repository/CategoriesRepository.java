package com.mike.ecommerce.repository;

import com.mike.ecommerce.model.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriesRepository extends JpaRepository<CategoriesEntity, Integer> {

    CategoriesEntity findByCategoryName(String tagName);

}
