package com.mugiwarec.app.model;

import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class OverLimit {

    @Id
    private final Long id;

    private Date payDate;

    @NotEmpty
    private BigDecimal amount;

    @NotEmpty
    private boolean statusPay;

    @NotEmpty
    private Date dateOfCreation;
}
