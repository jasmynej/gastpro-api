package org.gastpro.api.owners.infrastructure;

import org.gastpro.api.common.enums.AccountType;
import org.gastpro.api.common.events.AccountCreationEvent;
import org.gastpro.api.owners.domain.OwnerService;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class OwnersEventListeners {
    private final OwnerService ownerService;

    public OwnersEventListeners(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Async
    @ApplicationModuleListener
    public void on(AccountCreationEvent accountCreationEvent) {
        if (accountCreationEvent.getAccountType() == AccountType.OWNER) {
            System.out.println("Account creation event: " + accountCreationEvent);
            ownerService.createEmptyOwner(accountCreationEvent.getAccountId());
        }
    }
}
