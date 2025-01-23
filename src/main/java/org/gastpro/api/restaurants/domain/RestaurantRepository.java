package org.gastpro.api.restaurants.domain;

import org.gastpro.api.owners.domain.Owner;

import java.util.List;

public interface RestaurantRepository {
    Restaurant save(Restaurant restaurant);
    List<Restaurant> findByOwner(Owner owner);
    List<Restaurant> findAll();
    Restaurant findById(int id);
}
