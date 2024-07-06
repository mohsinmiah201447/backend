package com.isdbbros.realestate.model.config;

import com.isdbbros.realestate.model.super_classes.AuditableEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Location extends AuditableEntity {
    private String house;
    private String street;
    private String villageOrCity;
    private String thana;
    private String upazila;
    private String district;
    private String postalCode;
}
