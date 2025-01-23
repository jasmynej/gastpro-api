package org.gastpro.api.owners.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OwnerDetailUpdate {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

}
