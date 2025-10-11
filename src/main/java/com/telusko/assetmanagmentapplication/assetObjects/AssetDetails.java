package com.telusko.assetmanagmentapplication.assetObjects;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "asset_details")
public class AssetDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asset_details_id")
    private Long assetDetailsId;

    @Column(name="asset_id")
    private Long assetId;

    @ManyToOne
    @JoinColumn(name = "asset_id", referencedColumnName = "asset_id", insertable = false, updatable = false)
    private Assets assetDetails;

    @Column(name="employee_id")
    private Long employeeId;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", insertable = false, updatable = false)
    private Employees employeeDetails;

    @Column(name="location_id")
    private Long locationId;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "location_id", insertable = false, updatable = false)
    private Locations locationDetails;

    @Column(name="supplier_id")
    private Long supplierId;

    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id", insertable = false, updatable = false)
    private Suppliers supplierDetails;

    public AssetDetails() {
    }

    public AssetDetails(Long assetDetailsId, Assets asset, Employees employee, Locations location, Suppliers supplier) {
        this.assetDetailsId = assetDetailsId;
        this.assetDetails = asset;
        this.employeeDetails = employee;
        this.locationDetails = location;
        this.supplierDetails = supplier;
    }
}
