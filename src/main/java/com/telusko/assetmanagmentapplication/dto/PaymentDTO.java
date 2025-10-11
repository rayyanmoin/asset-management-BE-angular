package com.telusko.assetmanagmentapplication.dto;

import com.telusko.assetmanagmentapplication.assetObjects.Payment;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class PaymentDTO {


    private Long assetId;
    private Long supplierId;
    private Payment.PaymentMode paymentMode;
    private String chequeNumber;
    private LocalDate paymentDate;
    private BigDecimal amount;
    private BigDecimal amountToReturn;

}
