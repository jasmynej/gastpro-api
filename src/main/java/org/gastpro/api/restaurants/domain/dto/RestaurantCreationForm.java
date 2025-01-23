package org.gastpro.api.restaurants.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RestaurantCreationForm {
    private Integer ownerId;
    private String name;

}
