package org.gastpro.api.restaurants.infrastructure;

import org.gastpro.api.owners.domain.Owner;
import org.gastpro.api.restaurants.domain.Restaurant;
import org.gastpro.api.restaurants.domain.RestaurantRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantJpaRepository extends JpaRepository<Restaurant, Integer>, RestaurantRepository {
    List<Restaurant> findByOwner(Owner owner);

}