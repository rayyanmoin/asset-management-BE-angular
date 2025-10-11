package com.telusko.assetmanagmentapplication.dto;

import com.telusko.assetmanagmentapplication.assetObjects.Locations;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssetAddDTO {
    private Long assetId;
    private String assetName;
    private String description;
    private Long categoryId;
    private Double cost;

    private Long assetHistoryId;
    private Long locationId;
    private Integer year;
    private String assetHistory;

    private Long assetDetailsId;
    private Long employeeId;
    private Long supplierId;
}

