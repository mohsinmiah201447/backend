package com.isdbbros.realestate.model.config;

import com.isdbbros.realestate.model.super_classes.AuditableEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Branch extends AuditableEntity {
     private String name;
     private String address;
     private String contactNo;
}
