package com.mugiwarec.core.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "PAYMENT")
public class PaymentEntity extends BasicEntity {

    @Column(name = "date", nullable = false)
    @NotEmpty
    private Date date;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private List<PaymentLineEntity> paymentLineEntities;
}
