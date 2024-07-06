package com.isdbbros.realestate.model.config;

import com.isdbbros.realestate.model.super_classes.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Team extends AuditableEntity {
    private String name;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private Employee leader;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private List<Employee> members;
}
