package org.gastpro.api.menu.controller;

import org.gastpro.api.menu.domain.*;
import org.gastpro.api.menu.domain.dto.ItemMenuMapping;
import org.gastpro.api.menu.domain.dto.NewItemForm;
import org.gastpro.api.menu.domain.dto.NewMenuForm;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping("/create")
    public Menu createMenu(@RequestBody NewMenuForm newMenuForm) {
        return menuService.createMenu(newMenuForm);
    }

    @GetMapping("/{id}")
    public Menu getMenuById(@PathVariable int id) {
        return menuService.getMenuById(id);
    }

    @GetMapping("/all/{id}")
    public List<Menu> getAllMenusForRestaurant(@PathVariable int id) {
        return menuService.getMenusByRestaurantId(id);
    }

    @PostMapping("/create-item")
    public Item addItem(@RequestBody NewItemForm newItemForm) {
        return menuService.createItem(newItemForm);
    }

    @PostMapping("/add-item")
    public MenuItem addItem(@RequestBody ItemMenuMapping itemMenuMapping) {
        return menuService.addItemToMenu(itemMenuMapping);
    }

    @PostMapping("/create-items-batch/{restaurantId}")
    public List<Item> addItemBatch(@RequestBody List<NewItemForm> newItemForms, @PathVariable int restaurantId) {
        return menuService.createItems(newItemForms, restaurantId);
    }

    @PostMapping("/add-items-batch")
    public List<MenuItem> addMenuItemsBatch(@RequestBody List<ItemMenuMapping> itemMenuMappings) {
        return menuService.addItemsToMenu(itemMenuMappings);
    }

}
