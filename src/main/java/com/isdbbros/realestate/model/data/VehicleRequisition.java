package com.isdbbros.realestate.model.data;

import com.isdbbros.realestate.model.config.Client;
import com.isdbbros.realestate.model.config.Employee;
import com.isdbbros.realestate.model.config.Project;
import com.isdbbros.realestate.model.config.Team;
import com.isdbbros.realestate.model.super_classes.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
public class VehicleRequisition extends AuditableEntity {
    @Column(name = "requisitionNo")
    private int requisitionNo;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "employee")
    private Employee employee;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "team")
    private Team team;
    @Column(name = "visitingDate")
    private LocalDate visitingDate;
    @Column(name = "startingTime")
    private LocalTime startingTime;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "project")
    private Project project;
    @Column(name = "numberOfPersons")
    private Integer numberOfPersons;
    @Column(name = "staffPickUpPlace")
    private String staffPickUpPlace;
    @Column(name = "clientPickUpPlace")
    private String clientPickUpPlace;
    @Column(name = "pickUpTime")
    private LocalDate pickUpTime;
    @Column(name = "clientDropPlace")
    private String clientDropPlace;
    @Column(name = "personalMeetWithClient")
    private boolean personalMeetWithClient;
    @Column(name = "clientTalkByPriceList")
    private boolean clientTalkByPriceList;
    @Column(name = "meetingDate")
    private LocalDate meetingDate;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "client")
    private Client client;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "teamLeader")
    private Employee teamLeader;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "srGeneralManager")
    private Employee srGeneralManager;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "directorOfOperation")
    private Employee directorOfOperation;
}