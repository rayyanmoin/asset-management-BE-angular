package com.telusko.assetmanagmentapplication.repository;

import com.telusko.assetmanagmentapplication.assetObjects.AssetDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetDetailsRepo extends JpaRepository<AssetDetails, Long>{

}
