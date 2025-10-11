package com.telusko.assetmanagmentapplication.service;

import com.telusko.assetmanagmentapplication.assetObjects.*;
import com.telusko.assetmanagmentapplication.dto.AssetAddDTO;
import com.telusko.assetmanagmentapplication.dto.AssetDropDownDTO;
import com.telusko.assetmanagmentapplication.dto.CategoryAddDTO;
import com.telusko.assetmanagmentapplication.dto.SupplierDropDownDTO;
import com.telusko.assetmanagmentapplication.repository.AssetDetailsRepo;
import com.telusko.assetmanagmentapplication.repository.AssetHistoryRepo;
import com.telusko.assetmanagmentapplication.repository.AssetsRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssetsService {

    private  final AssetsRepo assetsRepo;
    private final AssetHistoryRepo assetHistoryRepo;
    private final AssetDetailsRepo assetDetailsRepo;

    public AssetsService(AssetsRepo assetsRepo, AssetHistoryRepo assetHistoryRepo, AssetDetailsRepo assetDetailsRepo) {
        this.assetsRepo = assetsRepo;
        this.assetDetailsRepo = assetDetailsRepo;
        this.assetHistoryRepo = assetHistoryRepo;
    }

    public List<Assets> getAllAssets() {
        return assetsRepo.findAll();
    }

    public List<AssetDropDownDTO> getAllAssetForDropDown(){
        List<Assets> assets = assetsRepo.findAll();
        List<AssetDropDownDTO> assetDropDownDTOS = new ArrayList<>();
        for(Assets assets1 : assets) {
            AssetDropDownDTO assetDropDownDTO = new AssetDropDownDTO();
            assetDropDownDTO.setAssetId(assets1.getAssetId());
            assetDropDownDTO.setAssetName(assets1.getAssetName() + assets1.getCost());
            assetDropDownDTOS.add(assetDropDownDTO);
        }
        return assetDropDownDTOS;
    }

    public String addAssets(@RequestBody AssetAddDTO assetAddDTO) {
        Assets assets = new Assets();
        assets.setAssetName(assetAddDTO.getAssetName());
        assets.setDescription(assetAddDTO.getDescription());
        assets.setCost(assetAddDTO.getCost());
        assets.setCategoryId(assetAddDTO.getCategoryId());
        Assets savedAsset = assetsRepo.save(assets);

        AssetHistory assetHistory = new AssetHistory();
        assetHistory.setAssetId(savedAsset.getAssetId());
        assetHistory.setLocationId(assetAddDTO.getLocationId());
        assetHistory.setYear(assetAddDTO.getYear());
        assetHistory.setAssetHistory(assetAddDTO.getAssetHistory());
        assetHistoryRepo.save(assetHistory);

        AssetDetails assetDetails = new AssetDetails();
        assetDetails.setAssetId(savedAsset.getAssetId());
        assetDetails.setEmployeeId(assetAddDTO.getEmployeeId());
        assetDetails.setLocationId(assetAddDTO.getLocationId());
        assetDetails.setSupplierId(assetAddDTO.getSupplierId());
        assetDetailsRepo.save(assetDetails);


        return "Asset saved successfully!";
    }

}