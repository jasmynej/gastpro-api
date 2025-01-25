package org.gastpro.api.menu.domain;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    Optional<Item> findById(Integer id);
    Item save(Item item);
    List<Item> saveAll(List<Item> items);
}
