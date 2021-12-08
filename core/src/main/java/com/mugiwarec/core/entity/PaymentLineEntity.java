package com.mugiwarec.core.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "PAYMENT_LINE")
public class PaymentLineEntity extends BasicEntity {

    @Column(name = "phone_number", nullable = false)
    @NotEmpty
    private String phoneNumber;

    @Column(name = "amount_received", nullable = false)
    @NotEmpty
    private BigDecimal amountReceived;
}
