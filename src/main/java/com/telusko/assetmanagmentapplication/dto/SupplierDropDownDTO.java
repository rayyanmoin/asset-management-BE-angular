package com.telusko.assetmanagmentapplication.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierDropDownDTO {

    private Long supplierId;
    private String supplierName;
}

