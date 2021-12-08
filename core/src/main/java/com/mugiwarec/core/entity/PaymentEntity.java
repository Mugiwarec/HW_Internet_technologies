package com.mugiwarec.core.entity;

import lombok.Data;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "PAYMENT")
public class PaymentEntity extends BasicEntity {

    @Column(name = "date", nullable = false)
    @NotNull
    private Date date;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private List<PaymentLineEntity> paymentLineEntities;

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
