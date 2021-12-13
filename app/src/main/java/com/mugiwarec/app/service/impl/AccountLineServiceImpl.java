package com.mugiwarec.app.service.impl;

import com.mugiwarec.app.mapper.AccountLineMapper;
import com.mugiwarec.app.model.AccountLine;
import com.mugiwarec.app.service.AccountLineService;
import com.mugiwarec.core.entity.AccountLineEntity;
import com.mugiwarec.core.repository.AccountLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AccountLineServiceImpl implements AccountLineService {

    private AccountLineRepository repository;

    @Override
    public Optional<AccountLine> findAccountLineById(Long id) {
        return repository.findById(id).map(AccountLineMapper.MAPPER::toAccountLine);
    }

    @Override
    public AccountLine saveAccountLine(AccountLine accountLine) {
        AccountLineEntity entity = repository.saveAndFlush(AccountLineMapper.MAPPER.toAccountLineEntity(accountLine));

        return AccountLineMapper.MAPPER.toAccountLine(entity);
    }

    @Override
    public AccountLine updateAccountLine(AccountLine accountLine) {
        Optional<AccountLineEntity> entity = repository.findById(accountLine.getId());

        if (entity.isPresent()) {
            repository.saveAndFlush(AccountLineMapper.MAPPER.toAccountLineEntity(accountLine));
        } else {
            throw new RuntimeException("AccountLine not found");
        }

        return accountLine;
    }

    @Override
    public String deleteAccountLine(Long id) {
        Optional<AccountLineEntity> entity = repository.findById(id);

        if (entity.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("AccountLine not found");
        }

        return "AccountLine was deleted";
    }
}
