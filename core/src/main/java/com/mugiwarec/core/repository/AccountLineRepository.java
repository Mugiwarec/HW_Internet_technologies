package com.mugiwarec.core.repository;

import com.mugiwarec.core.entity.AccountLineEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountLineRepository extends BasicJpaRepository<AccountLineEntity, Long> {
}
