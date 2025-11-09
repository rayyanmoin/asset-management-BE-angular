package com.telusko.assetmanagmentapplication.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationAddDTO {

    private Long locationId;
    private String locationName;
    private String locationCode;
    private String country;
    private String city;
    private String locationDescription;

}

