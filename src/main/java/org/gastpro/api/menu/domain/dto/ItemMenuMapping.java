package org.gastpro.api.menu.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ItemMenuMapping {
    private int itemId;
    private int menuId;
    private Double price;
}
