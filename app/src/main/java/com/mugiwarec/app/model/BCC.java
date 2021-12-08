package com.mugiwarec.app.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class BCC {

    @Id
    private final Long id;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private int limit;

    private List<OverLimit> overLimits;
}
