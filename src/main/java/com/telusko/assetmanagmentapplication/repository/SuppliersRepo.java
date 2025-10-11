package com.telusko.assetmanagmentapplication.repository;

import com.telusko.assetmanagmentapplication.assetObjects.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuppliersRepo extends JpaRepository<Suppliers, Long>{

}
