package com.telusko.assetmanagmentapplication.service;

import com.telusko.assetmanagmentapplication.assetObjects.AssetHistory;
import com.telusko.assetmanagmentapplication.repository.AssetHistoryRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AssetHistoryService {

    private  final AssetHistoryRepo assetHistoryRepo;

    public AssetHistoryService(AssetHistoryRepo assetHistoryRepo) {
        this.assetHistoryRepo = assetHistoryRepo;
    }

    public List<AssetHistory> getAllAssetsHistory() {

        return assetHistoryRepo.findAll();
    }

}