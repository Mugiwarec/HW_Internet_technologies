package com.mugiwarec.app.service.impl;

import com.mugiwarec.app.mapper.AccountMapper;
import com.mugiwarec.app.model.Account;
import com.mugiwarec.app.service.AccountService;
import com.mugiwarec.core.entity.AccountEntity;
import com.mugiwarec.core.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository repository;

    @Override
    public Optional<Account> findAccountById(Long id) {
        return repository.findById(id).map(AccountMapper.MAPPER::toAccount);
    }

    @Override
    public Account saveAccount(Account account) {
        AccountEntity entity = repository.saveAndFlush(AccountMapper.MAPPER.toAccountEntity(account));

        return AccountMapper.MAPPER.toAccount(entity);
    }

    @Override
    public Account updateAccount(Account account) {
        Optional<AccountEntity> entity = repository.findById(account.getId());

        if (entity.isPresent()) {
            repository.saveAndFlush(AccountMapper.MAPPER.toAccountEntity(account));
        } else {
            throw new RuntimeException("Account not found");
        }

        return account;
    }

    @Override
    public String deleteAccount(Long id) {
        Optional<AccountEntity> entity = repository.findById(id);

        if (entity.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Account not found");
        }

        return "Account was deleted";
    }
}
