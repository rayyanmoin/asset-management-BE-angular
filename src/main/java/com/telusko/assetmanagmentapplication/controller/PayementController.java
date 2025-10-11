package com.telusko.assetmanagmentapplication.controller;

import com.telusko.assetmanagmentapplication.dto.PaymentDTO;
import com.telusko.assetmanagmentapplication.dto.PaymentListDTO;
import com.telusko.assetmanagmentapplication.dto.SupplierDropDownDTO;
import com.telusko.assetmanagmentapplication.service.PayementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class PayementController {

    private final PayementService payementService;

    public PayementController(PayementService payementService) {
        this.payementService = payementService;
    }

    @PostMapping("/payment/add")
    public String addPayment(@RequestBody PaymentDTO paymentDTO) {
        return payementService.addPayment(paymentDTO);
    }

    @GetMapping("/payment/list")
    public List<PaymentListDTO> getAllPayments() {
        return payementService.getAllPayments();
    }

}
