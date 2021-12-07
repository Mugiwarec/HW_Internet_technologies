package com.mugiwarec.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BasicJpaRepository<T extends Serializable, I> extends JpaRepository<T, I> {
}
