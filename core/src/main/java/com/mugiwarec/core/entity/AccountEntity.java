package com.mugiwarec.core.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "ACCOUNT")
public class AccountEntity extends BasicEntity {

    @Column(name = "total_amount", nullable = false)
    @NotEmpty
    private BigDecimal totalAmount;

    @Column(name = "date", nullable = false)
    @NotEmpty
    private Date date;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private List<AccountLineEntity> accountLineEntities;
}
