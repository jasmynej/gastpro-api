package org.gastpro.api.common.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.gastpro.api.restaurants.domain.Restaurant;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class RestaurantCreatedEvent {
    private String resName;
    private Integer restaurantId;
    private String ownerEmail;
    private String ownerFirstName;
}
