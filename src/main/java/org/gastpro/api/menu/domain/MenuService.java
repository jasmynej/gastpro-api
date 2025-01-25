package org.gastpro.api.menu.domain;

import org.gastpro.api.menu.domain.dto.ItemMenuMapping;
import org.gastpro.api.menu.domain.dto.NewItemForm;
import org.gastpro.api.menu.domain.dto.NewMenuForm;
import org.gastpro.api.menu.infrastructure.ItemJpaRepository;
import org.gastpro.api.menu.infrastructure.MenuItemJpaRepository;
import org.gastpro.api.restaurants.domain.Restaurant;
import org.gastpro.api.restaurants.domain.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {
    private final MenuRepository menuRepository;
    private final RestaurantService restaurantService;
    private final ItemJpaRepository itemRepository;
    private final MenuItemJpaRepository menuItemRepository;

    public MenuService(MenuRepository menuRepository, RestaurantService restaurantService, ItemJpaRepository itemRepository, MenuItemJpaRepository menuItemRepository) {
        this.menuRepository = menuRepository;
        this.restaurantService = restaurantService;
        this.itemRepository = itemRepository;
        this.menuItemRepository = menuItemRepository;
    }

    public Menu getMenuById(Integer menuId) {
        return menuRepository.getMenuById(menuId);
    }

    public List<Menu> getMenusByRestaurantId(Integer restaurantId) {
        return menuRepository.getMenusByRestaurantId(restaurantId);
    }

    public Menu createMenu(NewMenuForm newMenuForm) {
        Menu menu = new Menu();
        Restaurant restaurant = restaurantService.getRestaurantById(newMenuForm.getRestaurantId());
        menu.setRestaurant(restaurant);
        menu.setName(newMenuForm.getName());
        return menuRepository.save(menu);
    }

    public Item createItem(NewItemForm newItemForm) {
        Item item = new Item();
        Restaurant restaurant = restaurantService.getRestaurantById(newItemForm.getRestaurantId());
        item.setRestaurant(restaurant);
        item.setName(newItemForm.getName());
        item.setCategory(newItemForm.getCategory());
        item.setDescription(newItemForm.getDescription());
        return itemRepository.save(item);
    }

    public MenuItem addItemToMenu(ItemMenuMapping itemMenuMapping) {
        MenuItem menuItem = new MenuItem();
        Item item = itemRepository.findById(itemMenuMapping.getItemId()).orElse(null);
        menuItem.setItem(item);
        Menu menu = menuRepository.getMenuById(itemMenuMapping.getMenuId());
        menuItem.setMenu(menu);
        menuItem.setPrice(itemMenuMapping.getPrice());
        return menuItemRepository.save(menuItem);
    }

    public List<Item> createItems(List<NewItemForm> newItemForm, int restaurantId) {
        List<Item> items = new ArrayList<>();
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        for (NewItemForm itemForm : newItemForm) {
            Item newItem = Item.createFromForm(itemForm, restaurant);
            items.add(newItem);
        }
        return itemRepository.saveAll(items);
    }

    public List<MenuItem> addItemsToMenu(List<ItemMenuMapping> itemMenuMapping) {
        List<MenuItem> menuItems = new ArrayList<>();
        for (ItemMenuMapping mapping : itemMenuMapping) {
            MenuItem menuItem = new MenuItem();
            Item item = itemRepository.findById(mapping.getItemId()).orElse(null);
            menuItem.setItem(item);
            Menu menu = menuRepository.getMenuById(mapping.getMenuId());
            menuItem.setMenu(menu);
            menuItem.setPrice(mapping.getPrice());
            menuItems.add(menuItem);
        }

        return menuItemRepository.saveAll(menuItems);
    }
}
