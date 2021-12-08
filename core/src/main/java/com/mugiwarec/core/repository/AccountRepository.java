package com.mugiwarec.core.repository;

import com.mugiwarec.core.entity.AccountEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends BasicJpaRepository<AccountEntity, Long> {
}
