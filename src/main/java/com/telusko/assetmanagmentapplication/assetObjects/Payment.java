package com.telusko.assetmanagmentapplication.assetObjects;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Payment_ID")
    private Integer paymentId;

    @Column(name = "Asset_ID")
    private Long assetId;

    @Column(name = "Supplier_ID")
    private Long supplierId;

    @Enumerated(EnumType.STRING)
    @Column(name = "Payment_Mode", nullable = false)
    private PaymentMode paymentMode;

    @Column(name = "Cheque_Number")
    private String chequeNumber;

    @Column(name = "Payment_Date", nullable = false)
    private LocalDate paymentDate;

    @Column(name = "Amount", precision = 12, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "Amount_to_return", precision = 12, scale = 2)
    private BigDecimal amountToReturn = BigDecimal.ZERO;

    // Relationships
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Asset_ID", nullable = false, insertable = false, updatable = false)
    private Assets asset;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Supplier_ID", nullable = false, insertable = false, updatable = false)
    private Suppliers supplier;

    // Enum for payment mode
    public enum PaymentMode {
        CHEQUE, CASH
    }

    }


