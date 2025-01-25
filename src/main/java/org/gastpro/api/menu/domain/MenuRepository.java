package org.gastpro.api.menu.domain;

import java.util.List;

public interface MenuRepository {
    Menu getMenuById(Integer menuId);
    List<Menu> getMenusByRestaurantId(Integer restaurantId);
    Menu save(Menu menu);
}
