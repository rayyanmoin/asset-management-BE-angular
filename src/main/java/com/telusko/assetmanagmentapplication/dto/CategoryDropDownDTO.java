package com.telusko.assetmanagmentapplication.dto;

import com.telusko.assetmanagmentapplication.assetObjects.Locations;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDropDownDTO {
    private Long categoryId;
    private String categoryName;
}

