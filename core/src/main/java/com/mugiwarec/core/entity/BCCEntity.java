package com.mugiwarec.core.entity;

import lombok.Data;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "BCC")
public class BCCEntity extends BasicEntity {

    @Column(name = "phone_number", nullable = false)
    @NotEmpty
    private String phoneNumber;

    @Column(name = "limit", nullable = false)
    @NotNull
    private Integer limit;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "bcc_id")
    private List<OverLimitEntity> overLimitEntities;

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
