package org.gastpro.api.restaurants.controller;

import org.gastpro.api.restaurants.domain.Restaurant;
import org.gastpro.api.restaurants.domain.RestaurantDetail;
import org.gastpro.api.restaurants.domain.RestaurantService;
import org.gastpro.api.restaurants.domain.dto.RestaurantCreationForm;
import org.gastpro.api.restaurants.domain.dto.RestaurantDetailForm;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;


    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/create")
    public Restaurant createRestaurant(@RequestBody RestaurantCreationForm restaurantCreationForm) {
        return restaurantService.createRestaurant(restaurantCreationForm);
    }

    @PostMapping("/add-details")
    public RestaurantDetail addRestaurantDetails(@RequestBody RestaurantDetailForm restaurantDetailForm) {
        return restaurantService.updateDetail(restaurantDetailForm);
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable int id) {
        return restaurantService.getRestaurantById(id);
    }
}
