package com.mugiwarec.app.service;

import com.mugiwarec.app.model.Account;

import java.util.Optional;

public interface AccountService {

    Optional<Account> findAccountById(Long id);

    Account saveAccount(Account account);

    Account updateAccount(Account account);

    String deleteAccount(Long id);
}
