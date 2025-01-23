package org.gastpro.api.common.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.gastpro.api.common.enums.AccountType;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class AccountCreationEvent {
    private Integer accountId;
    private AccountType accountType;
    private String email;

}
