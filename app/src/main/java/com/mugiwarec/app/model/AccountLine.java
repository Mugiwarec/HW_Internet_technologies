package com.mugiwarec.app.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class AccountLine {

    @Id
    private final Long id;

    @NotNull
    private BigDecimal amountToPay;

    @NotEmpty
    private String phoneNumber;

    @JsonCreator
    public AccountLine(@JsonProperty("id") Long id,
                       @JsonProperty("amount_to_pay") BigDecimal amountToPay,
                       @JsonProperty("phone_number") String phoneNumber) {
        this.id = id;
        this.amountToPay = amountToPay;
        this.phoneNumber = phoneNumber;
    }
}
