package com.telusko.assetmanagmentapplication.controller;

import com.telusko.assetmanagmentapplication.assetObjects.Assets;
import com.telusko.assetmanagmentapplication.assetObjects.Locations;
import com.telusko.assetmanagmentapplication.assetObjects.Suppliers;
import com.telusko.assetmanagmentapplication.dto.CategoryDropDownDTO;
import com.telusko.assetmanagmentapplication.dto.LocationAddDTO;
import com.telusko.assetmanagmentapplication.dto.SupplierAddDTO;
import com.telusko.assetmanagmentapplication.dto.SupplierDropDownDTO;
import com.telusko.assetmanagmentapplication.service.AssetsService;
import com.telusko.assetmanagmentapplication.service.LocationsService;
import com.telusko.assetmanagmentapplication.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

public class SupplierController {

    private final SuppliersService suppliersService;

    public SupplierController(SuppliersService suppliersService) {
        this.suppliersService = suppliersService;
    }

    @GetMapping("/suppliers")
    public List<Suppliers> getAllSuppliers() {

        return suppliersService.getAllSuppliers();
    }

    @GetMapping("/suppliers/dropList")
    public List<SupplierDropDownDTO> getAllSuppliersForDropDown() {
        return suppliersService.getAllSuppliersForDropDown();
    }

    @PostMapping("/suppliers/add")
    public String addSupplier(@RequestBody SupplierAddDTO supplierAddDTO) {
        return suppliersService.addSupplier(supplierAddDTO);
    }

    @PutMapping("/suppliers/update")
    public String updateLocation(@RequestBody SupplierAddDTO supplierAddDTO) {
        return suppliersService.updateSupplier(supplierAddDTO);
    }


}