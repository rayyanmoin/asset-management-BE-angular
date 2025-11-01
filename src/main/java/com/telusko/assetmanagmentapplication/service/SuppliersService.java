package com.telusko.assetmanagmentapplication.service;

import com.telusko.assetmanagmentapplication.assetObjects.Assets;
import com.telusko.assetmanagmentapplication.assetObjects.Categories;
import com.telusko.assetmanagmentapplication.assetObjects.Locations;
import com.telusko.assetmanagmentapplication.assetObjects.Suppliers;
import com.telusko.assetmanagmentapplication.dto.CategoryDropDownDTO;
import com.telusko.assetmanagmentapplication.dto.LocationAddDTO;
import com.telusko.assetmanagmentapplication.dto.SupplierAddDTO;
import com.telusko.assetmanagmentapplication.dto.SupplierDropDownDTO;
import com.telusko.assetmanagmentapplication.repository.SuppliersRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SuppliersService {

    private  final SuppliersRepo suppliersRepo;

    public SuppliersService(SuppliersRepo suppliersRepo) {
        this.suppliersRepo = suppliersRepo;
    }

    public List<Suppliers> getAllSuppliers() {

        return suppliersRepo.findAll();
    }

    public List<SupplierDropDownDTO> getAllSuppliersForDropDown() {
        List<Suppliers> suppliers = suppliersRepo.findAll();
        List<SupplierDropDownDTO> supplierDropDownDTOS = new ArrayList<>();
        for(Suppliers suppliers1 : suppliers) {
            SupplierDropDownDTO supplierDropDownDTO = new SupplierDropDownDTO();
            supplierDropDownDTO.setSupplierId(suppliers1.getSupplierId());
            supplierDropDownDTO.setSupplierName(suppliers1.getSupplierName());
            supplierDropDownDTOS.add(supplierDropDownDTO);
        }
        return supplierDropDownDTOS;
    }

    public String addSupplier(@RequestBody SupplierAddDTO supplierAddDTO) {
        Suppliers suppliers = new Suppliers();
        suppliers.setSupplierName(supplierAddDTO.getSupplierName());
        suppliers.setAddress(supplierAddDTO.getAddress());
        suppliers.setCountry(supplierAddDTO.getCountry());
        suppliers.setCity(supplierAddDTO.getCity());
        suppliers.setContactEmail(supplierAddDTO.getContactEmail());
        suppliers.setContactName(supplierAddDTO.getContactName());
        suppliers.setContactPhone(supplierAddDTO.getContactPhone());
        suppliers.setRegistrationNo(supplierAddDTO.getRegistrationNo());
        suppliers.setStatus(supplierAddDTO.getStatus());

        suppliersRepo.save(suppliers);
        return "Supplier saved successfully!";
    }


    public String updateSupplier(SupplierAddDTO supplierAddDTO) {
        Optional<Suppliers> suppliers = suppliersRepo.findById(supplierAddDTO.getSupplierId());
        if (suppliers.isPresent()) {
            Suppliers supplier = suppliers.get();

            supplier.setSupplierName(supplierAddDTO.getSupplierName());
            supplier.setAddress(supplierAddDTO.getAddress());
            supplier.setCountry(supplierAddDTO.getCountry());
            supplier.setCity(supplierAddDTO.getCity());
            supplier.setContactEmail(supplierAddDTO.getContactEmail());
            supplier.setContactName(supplierAddDTO.getContactName());
            supplier.setContactPhone(supplierAddDTO.getContactPhone());
            supplier.setRegistrationNo(supplierAddDTO.getRegistrationNo());
            supplier.setStatus(supplierAddDTO.getStatus());

            suppliersRepo.save(supplier);
            return "Supplier updated successfully!";
        }
        else {
            return "Supplier with Id Not found";
        }
    }

}