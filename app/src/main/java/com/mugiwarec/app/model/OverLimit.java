package com.mugiwarec.app.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class OverLimit {

    @Id
    private final Long id;

    private Date payDate;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private Boolean statusPay;

    @NotNull
    private Date dateOfCreation;

    @JsonCreator
    public OverLimit(@JsonProperty("id") Long id,
                     @JsonProperty("pay_date") Date payDate,
                     @JsonProperty("amount") BigDecimal amount,
                     @JsonProperty("status_pay") Boolean statusPay,
                     @JsonProperty("date_of_creation") Date dateOfCreation) {
        this.id = id;
        this.payDate = payDate;
        this.amount = amount;
        this.statusPay = statusPay;
        this.dateOfCreation = dateOfCreation;
    }
}
