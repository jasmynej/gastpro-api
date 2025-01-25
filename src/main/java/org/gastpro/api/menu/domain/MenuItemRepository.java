package org.gastpro.api.menu.domain;

import java.util.Optional;

public interface MenuItemRepository {
    Optional<MenuItem> findById(Integer id);
    MenuItem save(MenuItem menuItem);
}
