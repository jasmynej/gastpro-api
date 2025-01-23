package org.gastpro.api.owners.domain;

public interface OwnerRepository {
    Owner save(Owner owner);
    Owner findById(int id);
}
