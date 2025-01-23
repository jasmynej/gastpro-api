package org.gastpro.api.accounts.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.gastpro.api.common.enums.AccountType;

@Getter
@Setter
@AllArgsConstructor
public class AuthForm {
    private String email;
    private String password;
    private String type;
}
