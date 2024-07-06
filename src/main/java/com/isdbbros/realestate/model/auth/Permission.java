package com.isdbbros.realestate.model.auth;

import com.isdbbros.realestate.model.super_classes.AuditableEntity;
import com.isdbbros.realestate.model.super_classes.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Permission extends AuditableEntity {
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "componentKey", nullable = false, unique = true)
    private String componentKey;
    @Column(name = "description")
    private String description;
    @Column(name = "category")
    private String category;
}
