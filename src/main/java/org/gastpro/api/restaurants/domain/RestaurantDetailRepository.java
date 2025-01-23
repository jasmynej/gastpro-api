package org.gastpro.api.restaurants.domain;

public interface RestaurantDetailRepository {
    RestaurantDetail findById(int id);
    RestaurantDetail save(RestaurantDetail restaurantDetail);

}
