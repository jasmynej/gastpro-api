package org.gastpro.api.accounts.controller;

import org.gastpro.api.accounts.domain.Account;
import org.gastpro.api.accounts.domain.AccountService;
import org.gastpro.api.accounts.domain.dto.AuthForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public Account createAccount(@RequestBody AuthForm registrationForm) {
        System.out.println(registrationForm.getEmail());
        return accountService.createAccount(registrationForm);
    }

    @PostMapping("/login")
    public Account login(@RequestBody AuthForm loginForm) {
        return accountService.login(loginForm);
    }
}
