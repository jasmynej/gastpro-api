package org.gastpro.api.menu.infrastructure;

import org.gastpro.api.menu.domain.MenuItem;
import org.gastpro.api.menu.domain.MenuItemRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuItemJpaRepository extends JpaRepository<MenuItem, Integer>, MenuItemRepository {
    MenuItem save(MenuItem menuItem);
}