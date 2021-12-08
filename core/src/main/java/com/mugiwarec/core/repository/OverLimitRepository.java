package com.mugiwarec.core.repository;

import com.mugiwarec.core.entity.OverLimitEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface OverLimitRepository extends BasicJpaRepository<OverLimitEntity, Long> {
}
