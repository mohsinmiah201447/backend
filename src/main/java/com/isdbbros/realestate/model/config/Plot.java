package com.isdbbros.realestate.model.config;

import com.isdbbros.realestate.model.super_classes.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Plot extends AuditableEntity {
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "project")
    private Project project;
    @Column(name = "plotNo")
    private String plotNo;
    @Column(name = "roadNo")
    private String roadNo;
    @Column(name = "sectorNo")
    private String sectorNo;
    @Column(name = "ratePerKatha")
    private String ratePerKatha;
    @Column(name = "block")
    private String block;
    @Column(name = "areaInKatha")
    private String areaInKatha;
    @Column(name = "facing")
    private String facing;
    @Column(name = "totalPrice")
    private double totalPrice;
    @Column(name = "totalPriceInWords")
    private String totalPriceInWords;
}