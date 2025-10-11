package com.telusko.assetmanagmentapplication.controller;

import com.telusko.assetmanagmentapplication.assetObjects.AssetDetails;
import com.telusko.assetmanagmentapplication.assetObjects.Assets;
import com.telusko.assetmanagmentapplication.dto.AssetAddDTO;
import com.telusko.assetmanagmentapplication.dto.AssetDropDownDTO;
import com.telusko.assetmanagmentapplication.dto.SupplierDropDownDTO;
import com.telusko.assetmanagmentapplication.service.AssetDetailsService;
import com.telusko.assetmanagmentapplication.service.AssetsService;
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

public class AssetsController {

    private final AssetsService assetsService;
    private final AssetDetailsService assetDetailsService;

    public AssetsController(AssetsService assetsService, AssetDetailsService assetDetailsService) {
        this.assetsService = assetsService;
        this.assetDetailsService = assetDetailsService;
    }

    @GetMapping("/assets")
    public List<Assets> getAllAssets() {

        return assetsService.getAllAssets();
    }

    @GetMapping("/assetDrop")
    public List<AssetDropDownDTO> getAllAssetForDropDown() {
        return assetsService.getAllAssetForDropDown();
    }

    @GetMapping("/assetDetails")
    public List<AssetDetails> getAllAssetDetails() {
        return assetDetailsService.getAllAssetDetails();
    }

    @PostMapping("/assets/add")
    public String addAssets(@RequestBody AssetAddDTO assetAddDTO) {
        return assetsService.addAssets(assetAddDTO);
    }

}