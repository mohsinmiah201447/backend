package com.isdbbros.realestate.model.data;

import com.isdbbros.realestate.model.config.Employee;
import com.isdbbros.realestate.model.config.PaymentConfig;
import com.isdbbros.realestate.model.super_classes.ApprovableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Pre approval for sales.
 */
@Getter
@Setter
@Entity
public class SalesProposal extends ApprovableEntity {
    private String fileNo;
    private double sellerBm;
    private double sellerDp;
    private double sellerIns;
    private double teamLeadBm;
    private double teamLeadDp;
    private double teamLeadIns;
    private double seniorGmBm;
    private double seniorGmDp;
    private double seniorGmIns;
    private boolean soldByPriceList;
    private int applicationDuration;
    private LocalDate applicationDate;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private ClientApplication applicationDetails;
    private double listedPrice;
    private double soldPrice;
    private double discount;
    private double totalLandValue;
    private String totalLandValueWords;

    private double downPayment;
    private LocalDate downPaymentDate;
    private double downPayable;
    private LocalDate downPayableDate;
    private double restAmount;
    private double installmentAmount;
    private double grandTotal;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private PaymentConfig paymentConfig;
    private String remarks;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private Employee teamLeader;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private Employee seniorGM;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private Employee directorOperation;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private Employee managingDirector;

}
