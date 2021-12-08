package com.mugiwarec.core.entity;

import lombok.Data;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity extends BasicEntity {

    @Column(name = "name", nullable = false)
    @NotEmpty
    private String name;

    @Column(name = "surname", nullable = false)
    @NotEmpty
    private String surname;

    @Column(name = "birthday", nullable = false)
    @NotEmpty
    private Date birthday;

    @Column(name = "department", nullable = false)
    @NotEmpty
    private int department;

    @Column(name = "position", nullable = false)
    @NotEmpty
    private String position;

    @Column(name = "address", nullable = false)
    @NotEmpty
    private String address;

    @Column(name = "employment_date", nullable = false)
    @NotEmpty
    private Date employmentDate;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "employee_id")
    private List<BCCEntity> bccEntities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BasicEntity that = (BasicEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
