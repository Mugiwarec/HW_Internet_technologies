package com.mugiwarec.app.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class Account {

    @Id
    private final Long id;

    @NotNull
    private BigDecimal totalAmount;

    @NotNull
    private Date date;

    private List<AccountLine> accountLines;

    @JsonCreator
    public Account(@JsonProperty("id") Long id,
                   @JsonProperty("total_amount") BigDecimal totalAmount,
                   @JsonProperty("date") Date date,
                   @JsonProperty("account_lines") List<AccountLine> accountLines) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.date = date;
        this.accountLines = accountLines;
    }
}
