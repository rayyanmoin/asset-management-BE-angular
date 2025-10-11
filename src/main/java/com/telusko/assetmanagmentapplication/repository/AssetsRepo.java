package com.telusko.assetmanagmentapplication.repository;

import com.telusko.assetmanagmentapplication.assetObjects.Assets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetsRepo extends JpaRepository<Assets, Long>{

}
