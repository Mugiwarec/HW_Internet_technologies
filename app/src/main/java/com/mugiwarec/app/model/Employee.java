package com.mugiwarec.app.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class Employee {

    @Id
    private final Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String surname;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date birthday;

    @NotNull
    private Integer department;

    @NotEmpty
    private String position;

    @NotEmpty
    private String address;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date employmentDate;

    private List<BCC> bccs;

    @JsonCreator
    public Employee(@JsonProperty("id") Long id,
                    @JsonProperty("name") String name,
                    @JsonProperty("surname") String surname,
                    @JsonProperty("birthday") Date birthday,
                    @JsonProperty("department") Integer department,
                    @JsonProperty("position") String position,
                    @JsonProperty("address") String address,
                    @JsonProperty("employmentDate") Date employmentDate,
                    @JsonProperty("bccs") List<BCC> bccs) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.department = department;
        this.position = position;
        this.address = address;
        this.employmentDate = employmentDate;
        this.bccs = bccs;
    }

//    @JsonIgnore
//    public Employee withId(Long id) {
//        return new Employee(id,
//                this.name,
//                this.surname,
//                this.birthday,
//                this.department,
//                this.position,
//                this.address,
//                this.employmentDate,
//                this.bccs);
//    }
}
