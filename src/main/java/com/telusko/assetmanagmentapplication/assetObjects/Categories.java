package com.telusko.assetmanagmentapplication.assetObjects;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @Column(name = "category_description")
    private String categoryDescription;

    @Column(name = "category_code")
    private String categoryCode;

    public Categories() {
    }

    public Categories(Long categoryId, String categoryName, String categoryDescription, String categoryCode) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.categoryCode = categoryCode;

    }
}
