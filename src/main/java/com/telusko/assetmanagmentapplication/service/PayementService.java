package com.telusko.assetmanagmentapplication.service;

import com.telusko.assetmanagmentapplication.assetObjects.Payment;
import com.telusko.assetmanagmentapplication.assetObjects.Suppliers;
import com.telusko.assetmanagmentapplication.dto.PaymentDTO;
import com.telusko.assetmanagmentapplication.dto.PaymentListDTO;
import com.telusko.assetmanagmentapplication.dto.SupplierDropDownDTO;
import com.telusko.assetmanagmentapplication.repository.PayementRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class PayementService {

    private final PayementRepo payementRepo;

    public PayementService(PayementRepo payementRepo) {
        this.payementRepo = payementRepo;
    }

    public String addPayment(PaymentDTO paymentDTO) {
        Payment payement = new Payment();
        payement.setAssetId(paymentDTO.getAssetId());
        payement.setSupplierId(paymentDTO.getSupplierId());

        // Convert String → Enum
        payement.setPaymentMode(
                Payment.PaymentMode.valueOf(String.valueOf(paymentDTO.getPaymentMode()))
        );

        payement.setChequeNumber(paymentDTO.getChequeNumber());
        payement.setPaymentDate(paymentDTO.getPaymentDate());
        payement.setAmount(paymentDTO.getAmount());
        payement.setAmountToReturn(paymentDTO.getAmountToReturn());

        Payment saved = payementRepo.save(payement);
        return "Payment saved successfully! ID: " + saved.getPaymentId();
    }

    public List<PaymentListDTO> getAllPayments() {
        List<Payment> payments = payementRepo.findAll();
        List<PaymentListDTO> paymentDTOS = new ArrayList<>();
        for(Payment payment : payments) {
            PaymentListDTO paymentDTO = new PaymentListDTO();
            paymentDTO.setPaymentId(payment.getPaymentId());
            paymentDTO.setAssetName(payment.getAsset().getAssetName());
            paymentDTO.setSupplierName(payment.getSupplier().getSupplierName());
            paymentDTO.setPaymentMode(payment.getPaymentMode());
            paymentDTO.setChequeNumber(payment.getChequeNumber());
            paymentDTO.setPaymentDate(payment.getPaymentDate());
            paymentDTO.setAmount(payment.getAmount());
            paymentDTO.setAmountToReturn(payment.getAmountToReturn());
            paymentDTOS.add(paymentDTO);
        }
        return paymentDTOS;
    }

}
