package com.mugiwarec.core;

import com.mugiwarec.core.entity.BasicEntity;
import com.mugiwarec.core.repository.BasicJpaRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration(proxyBeanMethods = false)
@ComponentScan(basePackageClasses = ProjectJpaAutoConfiguration.class)
@EntityScan(basePackageClasses = BasicEntity.class)
@EnableJpaRepositories(basePackageClasses = BasicJpaRepository.class)
public class ProjectJpaAutoConfiguration {

}