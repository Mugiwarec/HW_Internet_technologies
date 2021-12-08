package com.mugiwarec.app.mapper;

import com.mugiwarec.app.model.Account;
import com.mugiwarec.core.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {

    AccountMapper MAPPER = Mappers.getMapper(AccountMapper.class);

    @Mapping(target = "accountLines", source = "entity.accountLineEntities")
    Account toAccount(AccountEntity entity);

    @Mapping(target = "accountLineEntities", source = "model.accountLines")
    AccountEntity toAccountEntity(Account model);
}
