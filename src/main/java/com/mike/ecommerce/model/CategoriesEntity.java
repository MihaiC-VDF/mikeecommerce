package com.mike.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
public class CategoriesEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "categoryId", nullable = false)
    private Integer categoryId;
    @Basic
    @Column(name = "categoryName")
    private String categoryName;

    @ManyToOne()
    @JoinColumn(name = "categoryParent",insertable = false, updatable = false)
    private CategoriesEntity categoriesParent;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "categoryId")
//    private List<CategoriesEntity> categoryChildren = new ArrayList<>();


    @ManyToMany(mappedBy = "categoriesList", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ProductEntity> products = new HashSet<>();



}
