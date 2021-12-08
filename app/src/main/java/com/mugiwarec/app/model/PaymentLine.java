package com.mugiwarec.app.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class PaymentLine {

    @Id
    private final Long id;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date;

    @NotNull
    private BigDecimal amountReceived;

    @JsonCreator
    public PaymentLine(@JsonProperty("id") Long id,
                       @JsonProperty("date") Date date,
                       @JsonProperty("amount_received") BigDecimal amountReceived) {
        this.id = id;
        this.date = date;
        this.amountReceived = amountReceived;
    }
}
