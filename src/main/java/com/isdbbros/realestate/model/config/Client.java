package com.isdbbros.realestate.model.config;

import com.isdbbros.realestate.constants.enums.District;
import com.isdbbros.realestate.model.super_classes.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Client extends AuditableEntity {
    @Column(name = "source")
    private String source;
    @Column(nullable = false, unique = true, updatable = false)
    private int clientId;
    @Column(name = "name")
    private String name;
    @Column(name = "fatherOrHusbandName")
    private String fatherOrHusbandName;
    @Column(name = "motherName")
    private String motherName;
    @Column(name = "company")
    private String company;
    @Column(name = "designation")
    private String designation;
    @Column(name = "profession")
    private String profession;
    @Column(name = "age")
    private String age;
    @Column(name = "residentialHouse")
    private String residentialHouse;
    @Enumerated(EnumType.STRING)
    @Column(name = "district")
    private District district;
    @Column(name = "phone")
    private String phone;
    @Column(name = "currentAddress")
    private String currentAddress;
    @Column(name = "permanentAddress")
    private String permanentAddress;
    @Column(name = "email")
    private String email;
    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "nid")
    private String nid;
    @Column(name = "tinNo")
    private String tinNo;
    @Column(name = "religion")
    private String religion;
    @Column(name = "maritalStatus")
    private String maritalStatus;
    @Column(name = "nomineeName")
    private String nomineeName;
    @Column(name = "nomineeRelation")
    private String nomineeRelation;
    @Column(name = "nomineeAddress")
    private String nomineeAddress;
    @Column(name = "nomineeNid")
    private String nomineeNid;
    @Column(name = "nomineePhone")
    private String nomineePhone;
}