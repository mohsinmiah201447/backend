package com.isdbbros.realestate.model.data;

import com.isdbbros.realestate.constants.enums.SalesMode;
import com.isdbbros.realestate.constants.enums.PaymentType;
import com.isdbbros.realestate.model.config.Client;
import com.isdbbros.realestate.model.config.Employee;
import com.isdbbros.realestate.model.config.Plot;
import com.isdbbros.realestate.model.super_classes.ApprovableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class ClientApplication extends ApprovableEntity {
    @Column(name = "fileNo")
    private String fileNo;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "applicant")
    private Client applicant;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "plot")
    private Plot plotDetails;
    @Enumerated(EnumType.STRING)
    @Column(name = "salesMode")
    private SalesMode salesMode;
    @Column(name = "bookingMoney")
    private double bookingMoney;
    @Column(name = "bookingPayMedia")
    private String bookingPayMedia;
    @Column(name = "payment")
    private String payment;
    @Column(name = "bookingPayDate")
    private LocalDate bookingPayDate;
    @Column(name = "bank")
    private String bank;
    @Column(name = "branch")
    private String branch;
    @Enumerated(EnumType.STRING)
    @Column(name = "paymentType")
    private PaymentType paymentType;
    @Column(name = "paymentPercentage")
    private double paymentPercentage;
    @Column(name = "paymentAmount")
    private double paymentAmount;
    @Column(name = "paymentDate")
    private LocalDate paymentDate;
    @Column(name = "noOfInstallment")
    private int noOfInstallment;
    @Column(name = "installmentAmount")
    private double installmentAmount;
    @Column(name = "installmentStartDate")
    private LocalDate installmentStartDate;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "seller")
    private Employee seller;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "authorized_by")
    private Employee authorizedBy;
}
