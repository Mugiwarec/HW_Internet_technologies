package com.mugiwarec.core.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "ACCOUNT_LINE")
public class AccountLineEntity extends BasicEntity {

    @Column(name = "amount_to_pay", nullable = false)
    @NotEmpty
    private BigDecimal amountToPay;

    @Column(name = "phone_number", nullable = false)
    @NotEmpty
    private String phoneNumber;
}
