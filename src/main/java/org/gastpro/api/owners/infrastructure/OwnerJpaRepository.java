package org.gastpro.api.owners.infrastructure;

import org.gastpro.api.owners.domain.Owner;
import org.gastpro.api.owners.domain.OwnerRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerJpaRepository extends JpaRepository<Owner, Integer>, OwnerRepository {
}
