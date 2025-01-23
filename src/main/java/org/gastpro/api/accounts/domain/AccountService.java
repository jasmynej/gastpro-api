package org.gastpro.api.accounts.domain;

import org.gastpro.api.accounts.domain.dto.AuthForm;
import org.gastpro.api.common.enums.AccountType;
import org.gastpro.api.common.events.AccountCreationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final PasswordService passwordService;
    private final ApplicationEventPublisher eventPublisher;

    public AccountService(AccountRepository accountRepository, PasswordService passwordService, ApplicationEventPublisher eventPublisher) {
        this.accountRepository = accountRepository;
        this.passwordService = passwordService;
        this.eventPublisher = eventPublisher;
    }

    public Account login(AuthForm loginForm) {
        Account foundAccount = accountRepository.findByEmailAndType(loginForm.getEmail(), AccountType.valueOf(loginForm.getType()));
        if (foundAccount == null) {
            return null;
        }

        if(passwordService.verifyPassword(loginForm.getPassword(), foundAccount.getPasswordHash())){
            return foundAccount;
        }
        return null;
    }

    @Transactional
    public Account createAccount(AuthForm registrationForm) {
        Account account = new Account();
        account.setEmail(registrationForm.getEmail());
        account.setPasswordHash(registrationForm.getPassword());
        account.setType(AccountType.valueOf(registrationForm.getType()));
        Account savedAccount = accountRepository.save(account);

        AccountCreationEvent accountCreationEvent = new AccountCreationEvent(savedAccount.getId(),savedAccount.getType(), savedAccount.getEmail());
        eventPublisher.publishEvent(accountCreationEvent);
        return savedAccount;
    }

    public Account findAccountById(Integer id) {
        return accountRepository.findById(id);
    }

}
