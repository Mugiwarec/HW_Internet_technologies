package com.mugiwarec.core.repository;

import com.mugiwarec.core.entity.BCCEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface BCCRepository extends BasicJpaRepository<BCCEntity, Long> {
}
