package com.isdbbros.realestate.model.data;

import com.isdbbros.realestate.model.config.Client;
import com.isdbbros.realestate.model.config.Employee;
import com.isdbbros.realestate.model.super_classes.AuditableEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
public class Schedule extends AuditableEntity {
    private LocalDate scheduleDate;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private Employee employee;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private Employee driver;
    private int personCount;
    private String staffPickUpPlace;
    private String clientPickUpPlace;
    private LocalTime startingTime;
    private LocalTime clientPickUpTime;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private Client client;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private VehicleRequisition requisition;
}
