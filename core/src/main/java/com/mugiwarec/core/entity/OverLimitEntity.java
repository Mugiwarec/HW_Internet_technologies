package com.mugiwarec.core.entity;

import lombok.Data;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Data
@Entity
@Table(name = "OVER_LIMIT")
public class OverLimitEntity extends BasicEntity {

    @Column(name = "pay_date")
    private Date payDate;

    @Column(name = "amount", nullable = false)
    @NotEmpty
    private BigDecimal amount;

    @Column(name = "status_pay", nullable = false)
    @NotEmpty
    private boolean statusPay;

    @Column(name = "date_of_creation", nullable = false)
    @NotEmpty
    private Date dateOfCreation;

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
