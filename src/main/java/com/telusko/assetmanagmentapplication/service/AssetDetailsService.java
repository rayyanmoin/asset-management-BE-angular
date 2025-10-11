package com.telusko.assetmanagmentapplication.service;

import com.telusko.assetmanagmentapplication.assetObjects.AssetDetails;
import com.telusko.assetmanagmentapplication.repository.AssetDetailsRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AssetDetailsService {

    private  final AssetDetailsRepo assetDetailsRepo;

    public AssetDetailsService(AssetDetailsRepo assetDetailsRepo) {
        this.assetDetailsRepo = assetDetailsRepo;
    }

    public List<AssetDetails> getAllAssetDetails() {

        List<AssetDetails> assetDetails =  assetDetailsRepo.findAll();
        return  assetDetails;
    }

}