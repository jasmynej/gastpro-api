package org.gastpro.api.restaurants.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RestaurantDetailForm {
    private Integer restaurantId;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String cuisine;
}
