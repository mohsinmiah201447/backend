package com.isdbbros.realestate.model.data;

import com.isdbbros.realestate.model.super_classes.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Payment extends BaseEntity {
    private String reason; // Formatted class names from the payment related entities
    private long reference; // ID from the payment related entity
    private LocalDateTime date;
    private double amount;
}
