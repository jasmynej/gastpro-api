package org.gastpro.api.accounts.infrastructure;

import org.gastpro.api.accounts.domain.Account;
import org.gastpro.api.accounts.domain.AccountRepository;
import org.gastpro.api.common.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountJpaRepository extends JpaRepository<Account, Integer>, AccountRepository {
    Account findByEmailAndType(String email, AccountType type);

    Account findById(int id);

}
