package org.gastpro.api.menu.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.gastpro.api.common.enums.ItemCategory;


@Getter
@Setter
@AllArgsConstructor
public class NewItemForm {
    private int restaurantId;
    private String name;
    private String description;
    private ItemCategory category;

}
