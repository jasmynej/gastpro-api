package org.gastpro.api.menu.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NewMenuForm {
    private Integer restaurantId;
    private String name;
}
