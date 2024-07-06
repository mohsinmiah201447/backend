package com.isdbbros.realestate.model.data;

import com.isdbbros.realestate.model.config.Employee;
import com.isdbbros.realestate.model.super_classes.AuditableEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class CommissionRequisition extends AuditableEntity {
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private Employee employee;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private SalesProposal salesProposal;
    private String salesType;
    private double bookingAmount;
    private double downPayAmount;
    private double partPayAmount;
    private double installmentAmount;
    private LocalDate date;
    private double commission;
    private String remarks;

}
