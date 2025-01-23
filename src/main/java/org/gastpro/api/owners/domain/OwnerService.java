package org.gastpro.api.owners.domain;

import org.gastpro.api.accounts.domain.Account;
import org.gastpro.api.accounts.domain.AccountService;
import org.gastpro.api.owners.domain.dto.OwnerDetailUpdate;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;
    private final AccountService accountService;
    public OwnerService(OwnerRepository ownerRepository, AccountService accountService) {
        this.ownerRepository = ownerRepository;
        this.accountService = accountService;
    }

    public Owner createEmptyOwner(int accountId) {
        Owner owner = new Owner();
        Account account = accountService.findAccountById(accountId);
        owner.setAccounts(account);
        return ownerRepository.save(owner);
    }

    public Owner updateOwner(OwnerDetailUpdate ownerDetailUpdate) {
        Owner owner = ownerRepository.findById(ownerDetailUpdate.getId());
        owner.setFirstName(ownerDetailUpdate.getFirstName());
        owner.setLastName(ownerDetailUpdate.getLastName());
        owner.setPhoneNumber(ownerDetailUpdate.getPhoneNumber());
        return ownerRepository.save(owner);
    }

    public Owner getOwnerById(int ownerId) {
        return ownerRepository.findById(ownerId);
    }
}
