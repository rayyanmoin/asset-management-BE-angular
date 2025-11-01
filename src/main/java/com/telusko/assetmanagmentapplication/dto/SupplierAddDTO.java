package com.telusko.assetmanagmentapplication.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierAddDTO {

    private Long supplierId;
    private String supplierName;
    private String contactName;
    private String contactEmail;
    private String contactPhone;
    private String address;
    private String country;
    private String city;
    private String registrationNo;
    private String status;
}

