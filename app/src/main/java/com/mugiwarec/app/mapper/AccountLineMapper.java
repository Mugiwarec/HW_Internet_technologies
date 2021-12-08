package com.mugiwarec.app.mapper;

import com.mugiwarec.app.model.AccountLine;
import com.mugiwarec.core.entity.AccountLineEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountLineMapper {

    AccountLineMapper MAPPER = Mappers.getMapper(AccountLineMapper.class);

    AccountLine toAccountLine(AccountLineEntity entity);

    AccountLineEntity toAccountLineEntity(AccountLine model);
}
