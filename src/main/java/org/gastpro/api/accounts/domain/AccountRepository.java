package org.gastpro.api.accounts.domain;

import org.gastpro.api.common.enums.AccountType;

public interface AccountRepository {
    Account findByEmailAndType(String email, AccountType type);
    Account findById(int id);
    Account save(Account account);
}
