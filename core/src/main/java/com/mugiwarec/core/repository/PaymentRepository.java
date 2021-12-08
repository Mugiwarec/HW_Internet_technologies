package com.mugiwarec.core.repository;

import com.mugiwarec.core.entity.PaymentEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends BasicJpaRepository<PaymentEntity, Long> {
}
