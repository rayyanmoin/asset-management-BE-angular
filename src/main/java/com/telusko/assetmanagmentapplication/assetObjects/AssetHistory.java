package com.telusko.assetmanagmentapplication.assetObjects;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "asset_history")
public class AssetHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assetHistory_id")
    private Long assetHistoryId;

    @Column(name="asset_id")
    private Long assetId;

    @ManyToOne
    @JoinColumn(name = "asset_id", referencedColumnName = "asset_id", insertable = false, updatable = false)
    private Assets assetDetails;

    @Column(name="location_id")
    private Long locationId;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "location_id", insertable = false, updatable = false)
    private Locations locationDetails;

    @Column(name = "year")
    private Integer year;

    @Column(name = "asset_history")
    private String assetHistory;

    public AssetHistory() {
    }

    public AssetHistory(Long assetHistoryId, Assets asset, Locations location, Integer year, String assetHistory) {
        this.assetHistoryId = assetHistoryId;
        this.assetDetails = asset;
        this.locationDetails = location;
        this.year = year;
        this.assetHistory = assetHistory;
    }
}
