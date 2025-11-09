package com.telusko.assetmanagmentapplication.assetObjects;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Locations")

public class Locations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "location_name")
    private String locationName;

    @Column(name = "location_code")
    private String locationCode;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name= "location_description")
    private String locationDescription;

    public Locations() {
    }


    public Locations(Long locationId, String locationName, String locationCode, String country, String city,String locationDescription) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.locationCode = locationCode;
        this.country = country;
        this.city = city;
        this.locationDescription = locationDescription;
    }
}
