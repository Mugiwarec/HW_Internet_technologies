package com.mugiwarec.app.service;

import com.mugiwarec.app.model.AccountLine;

import java.util.Optional;

public interface AccountLineService {

    Optional<AccountLine> findAccountLineById(Long id);

    AccountLine saveAccountLine(AccountLine accountLine);

    AccountLine updateAccountLine(AccountLine accountLine);

    String deleteAccountLine(Long id);
}
