package com.mugiwarec.app.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class Payment {

    @Id
    private final Long id;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date;

    private List<PaymentLine> paymentLines;

    @JsonCreator
    public Payment(@JsonProperty("id") Long id,
                   @JsonProperty("date") Date date,
                   @JsonProperty("payment_lines") List<PaymentLine> paymentLines) {
        this.id = id;
        this.date = date;
        this.paymentLines = paymentLines;
    }
}
