package org.gastpro.api.restaurants.infrastructure;

import org.gastpro.api.restaurants.domain.RestaurantDetail;
import org.gastpro.api.restaurants.domain.RestaurantDetailRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantDetailJpaRepository extends JpaRepository<RestaurantDetail, Integer>, RestaurantDetailRepository {
    RestaurantDetail findById(int id);

}