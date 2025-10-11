package com.telusko.assetmanagmentapplication.repository;

import com.telusko.assetmanagmentapplication.assetObjects.AssetHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetHistoryRepo extends JpaRepository<AssetHistory, Long>{

}
