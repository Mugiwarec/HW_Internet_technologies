package com.mugiwarec.app.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Data
public class Employee {

    @Id
    private final int id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String surname;

    @NotEmpty
    private Date birthday;

    @NotEmpty
    private int department;

    @NotEmpty
    private String position;

    @NotEmpty
    private String address;

    @NotEmpty
    private Date employmentDate;

    private List<BCC> bccs;
}
