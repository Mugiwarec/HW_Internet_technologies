package com.mugiwarec.app.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class BCC {

    @Id
    private final Long id;

    @NotEmpty
    private String phoneNumber;

    @NotNull
    private Integer limit;

    private List<OverLimit> overLimits;

    @JsonCreator
    public BCC(@JsonProperty("id") Long id,
               @JsonProperty("phone_number") String phoneNumber,
               @JsonProperty("limit") Integer limit,
               @JsonProperty("over_limits") List<OverLimit> overLimits) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.limit = limit;
        this.overLimits = overLimits;
    }
}
