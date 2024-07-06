package com.isdbbros.realestate.model.config;

import com.isdbbros.realestate.model.super_classes.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PaymentConfig extends AuditableEntity {
    @Column(name = "configId", unique = true, nullable = false)
    private String name;
    @Column(name = "bookingMoneyPerKatha")
    private double bookingMoneyPerKatha;
    @Column(name = "onePaymentDuration")
    private double onePaymentDuration;
    @Column(name = "downPaymentDuration")
    private double downPaymentDuration;
    @Column(name = "downPaymentPercentage")
    private double downPaymentPercentage;
    @Column(name = "delayCharge")
    private double delayCharge;
}
