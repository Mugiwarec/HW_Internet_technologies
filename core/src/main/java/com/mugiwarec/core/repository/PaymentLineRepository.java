package com.mugiwarec.core.repository;

import com.mugiwarec.core.entity.PaymentLineEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentLineRepository extends BasicJpaRepository<PaymentLineEntity, Long> {
}
