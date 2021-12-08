package com.mugiwarec.app.mapper;

import com.mugiwarec.app.model.Employee;
import com.mugiwarec.core.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(target = "bccs", source = "entity.bccEntities")
    Employee toEmployee(EmployeeEntity entity);

    @Mapping(target = "bccEntities", source = "model.bccs")
    EmployeeEntity toEmployeeEntity(Employee model);
}
