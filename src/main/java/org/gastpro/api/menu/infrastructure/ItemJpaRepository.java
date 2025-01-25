package org.gastpro.api.menu.infrastructure;

import org.gastpro.api.menu.domain.Item;
import org.gastpro.api.menu.domain.ItemRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemJpaRepository extends JpaRepository<Item, Integer> {
  Optional<Item> findById(Integer id);
}