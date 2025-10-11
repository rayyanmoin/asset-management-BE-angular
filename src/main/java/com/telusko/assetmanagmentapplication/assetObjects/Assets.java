package com.telusko.assetmanagmentapplication.assetObjects;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "assets")
public class Assets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asset_id")
    private Long assetId;

    @Column(name = "asset_name", nullable = false)
    private String assetName;

    @Column(name ="description")
    private String description;

    @Column(name="category_id")
    private Long categoryId;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", insertable = false, updatable = false)
    private Categories categoryDetails;

    @Column(name = "cost", nullable = false, precision = 10)
    private Double cost;

    public Assets() {
    }

    public Assets(Long assetId, String assetName, Categories category, Double cost, String description) {
        this.assetId = assetId;
        this.assetName = assetName;
        this.categoryDetails = category;
        this.cost = cost;
        this.description = description;
    }
}
