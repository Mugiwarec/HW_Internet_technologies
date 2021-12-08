package com.mugiwarec.core.repository;

import com.mugiwarec.core.entity.EmployeeEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends BasicJpaRepository<EmployeeEntity, Long> {
}
