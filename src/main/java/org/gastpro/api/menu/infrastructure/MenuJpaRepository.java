package org.gastpro.api.menu.infrastructure;

import org.gastpro.api.menu.domain.Menu;
import org.gastpro.api.menu.domain.MenuRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuJpaRepository extends JpaRepository<Menu, Integer>, MenuRepository {
  Menu getMenuById(Integer menuId);
  List<Menu> getMenusByRestaurantId(Integer restaurantId);
  Menu save(Menu menu);
}