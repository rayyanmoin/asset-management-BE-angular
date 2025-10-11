package com.telusko.assetmanagmentapplication.repository;

import com.telusko.assetmanagmentapplication.assetObjects.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayementRepo extends JpaRepository<Payment,Integer> {
}
