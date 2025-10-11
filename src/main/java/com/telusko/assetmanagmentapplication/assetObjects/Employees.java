package com.telusko.assetmanagmentapplication.assetObjects;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "employee_name", nullable = false)
    private String employeeName;

    @Column(name="location_id")
    private Long locationId;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "location_id",insertable = false, updatable = false)
    private Locations locationDetails;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "contact_phone", length = 20)
    private String contactPhone;

    @Column(name = "address")
    private String address;

    public Employees() {
    }

    public Employees(Long employeeId, String employeeName, Locations locationDetails, String contactEmail, String contactPhone, String address) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.locationDetails = locationDetails;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.address = address;
    }
}
