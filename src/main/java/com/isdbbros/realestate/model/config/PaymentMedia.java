package com.isdbbros.realestate.model.config;

import com.isdbbros.realestate.model.super_classes.AuditableEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * @data {CASH, CHEQUE, PO, DD}
 */
@Getter
@Setter
@Entity
public class PaymentMedia extends AuditableEntity {
    private String name;
}

