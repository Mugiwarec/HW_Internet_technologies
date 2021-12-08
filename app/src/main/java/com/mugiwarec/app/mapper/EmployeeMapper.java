package com.mugiwarec.app.mapper;

import com.mugiwarec.app.model.Employee;
import com.mugiwarec.core.entity.EmployeeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper MAPPER = Mappers.getMapper(EmployeeMapper.class);

    Employee toEmployee(EmployeeEntity entity);

    EmployeeEntity toEmployeeEntity(Employee model);
}
